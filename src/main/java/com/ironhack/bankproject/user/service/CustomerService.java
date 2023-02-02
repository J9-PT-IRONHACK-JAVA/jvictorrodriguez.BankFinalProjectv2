package com.ironhack.bankproject.user.service;

import com.ironhack.bankproject.user.dto.CustomerDTO;
import com.ironhack.bankproject.user.exception.EmailNotFoundException;
import com.ironhack.bankproject.user.model.Customer;
import com.ironhack.bankproject.user.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public CustomerDTO create(@RequestBody @Valid CustomerDTO customerDTO) {
        var customerNew= customerRepository.save(Customer.fromDTO(customerDTO));
        return CustomerDTO.fromCustomer(customerNew);
    }

    public CustomerDTO update(CustomerDTO customerDTO) {
        //Looks for the user by username. if it doesn't exist throws an exception
        //else updates all 5 attributes
        var customerToUpdate= findByEmail(customerDTO.getUsername());
        customerToUpdate.setPassword(customerDTO.getPassword());
        customerToUpdate.setName(customerDTO.getName());
        customerToUpdate.setEmail(customerDTO.getEmail());
        customerToUpdate.setDni(customerDTO.getDni());
        customerToUpdate=customerRepository.save(customerToUpdate);
        return CustomerDTO.fromCustomer(customerToUpdate);
    }



    public CustomerDTO updatePatchMethod(CustomerDTO customerDTO) {
        var customerToUpdate = findByEmail(customerDTO.getUsername());
//        if(!customerDTO.getRoles(){
//            customerToUpdate.setRoles(customerDTO.getRoles());
//        }
//        if (!customerDTO.getEmail().isEmpty()){
//            customerToUpdate.setEmail(customerDTO.getEmail());
//        }
        if(!customerDTO.getName().isEmpty()){
            customerToUpdate.setName(customerDTO.getName());
        }
        if(!customerDTO.getPassword().isEmpty()){
            customerToUpdate.setPassword(customerDTO.getPassword());}
        return CustomerDTO.fromCustomer(customerToUpdate);
    }

    public void delete(CustomerDTO customerDTO) {
        customerRepository.deleteById(customerDTO.getId());
    }

    private Customer findByEmail(String email){
        return customerRepository.findByEmail(email).orElseThrow(()-> new EmailNotFoundException(email));
    }
}
