package com.ironhack.bankproject.account.service;

import com.ironhack.bankproject.account.dto.AccountDTO;
import com.ironhack.bankproject.account.exceptions.AccountTypeNotFoundException;
import com.ironhack.bankproject.account.model.*;
import com.ironhack.bankproject.account.repository.AccountRepository;
import com.ironhack.bankproject.user.dto.CustomerDTO;
import com.ironhack.bankproject.user.exception.UserNotFoundException;
import com.ironhack.bankproject.user.model.Customer;
import com.ironhack.bankproject.user.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public List<Account> findAll() {
        return accountRepository.findAll();
    }


    public Account create(AccountDTO accountDTO) {
        //Obtains the list of no repeated customers' dni
        var customersDni= accountDTO.getCustomers();
        //Creates a list to store customerObjects
        List<Customer> customerList=new ArrayList<>();
        //Iterates the list of dni and creates a list of customers
        for (CustomerDTO customerDTO: accountDTO.getCustomers()) {
            if(customerRepository.findByDni(customerDTO.getDni()).isPresent()){
                customerList.add(customerRepository.findByDni(customerDTO.getDni()).get());
            }else{
                throw new UserNotFoundException(customerDTO.getDni());
            }
        }
        Account newAccount = null;

        var accountType= accountDTO.getAccountType();
        switch (accountType) {
            case CHECKING_ACCOUNT ->
            {
                //Check age first customer
                if(hasStudentAge(customerList.get(0).getDni())){
                    newAccount = new StudentAccount();
                }else {
                    newAccount = new CheckingAccount();
                }
            }

            case STUDENT_ACCOUNT ->  newAccount= new StudentAccount();

            case SAVINGS_ACCOUNT -> newAccount= new SavingsAccount();

            case CREDITCARD ->  newAccount=new CreditCard();

            default -> throw new AccountTypeNotFoundException(accountType);
        }
        newAccount.addOwners(customerList);
        newAccount=accountRepository.save(newAccount);
        return newAccount;
        }


    public boolean hasStudentAge (String dni){
        int studentAgeLower=24;
        String dob = "01/01/1900";
        if (customerRepository.findByDni(dni).isPresent()){
           dob=customerRepository.findByDni(dni).get().getDOB()   ;
            System.out.println(dob);
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate fechaNacimiento = LocalDate.parse(dob, formatter);
        Period edad = Period.between(fechaNacimiento, LocalDate.now());
        int age = edad.getYears();
        System.out.println(age);
        return age < studentAgeLower;


    }

}
