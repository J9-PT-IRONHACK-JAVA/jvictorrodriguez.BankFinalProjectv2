package com.ironhack.bankproject.account.service;

import com.ironhack.bankproject.Money;
import com.ironhack.bankproject.account.dto.AccountDTO;
import com.ironhack.bankproject.account.enums.AccountType;
import com.ironhack.bankproject.account.model.Account;
import com.ironhack.bankproject.account.model.CheckingAccount;
import com.ironhack.bankproject.account.model.StudentAccount;
import com.ironhack.bankproject.account.repository.AccountRepository;
import com.ironhack.bankproject.user.dto.AdminDTO;
import com.ironhack.bankproject.user.model.Admin;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

import static com.ironhack.bankproject.account.enums.AccountType.*;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;

    public List<Account> findAll() {
        return accountRepository.findAll();
    }


    public AccountDTO create(AccountDTO accountDTO) {
        switch (accountDTO.getAccountType()) {
            case CHECKING_ACCOUNT ->  {
                        accountRepository.save(new CheckingAccount());
                }
                case STUDENT_ACCOUNT -> {
                    accountRepository.save(new StudentAccount());
                }
//                case SAVINGS_ACCOUNT -> {
//                    accountRepository.save(new SavinsAccount());
//                }
//                case CREDITCARD -> {
//                    accountRepository.save(new CreditCard());
//                }
            }

//        public AdminDTO create(AdminDTO adminDTO){
//            var adminNew= adminRepository.save(Admin.fromDTO(adminDTO));
//            return AdminDTO.fromAdmin(adminNew);
//        }
        //var accountNew = accountRepository.save(Account.fromDTO(accountDTO));
        //return AccountDTO.fromAccount(accountNew);
//        var customerNew= customerRepository.save(Customer.fromDTO(customerDTO));
//        return CustomerDTO.fromCustomer(customerNew);
//        return null;
        return null;
    }
}
