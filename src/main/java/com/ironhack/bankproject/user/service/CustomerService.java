package com.ironhack.bankproject.user.service;

import com.ironhack.bankproject.user.dto.AdminDTO;
import com.ironhack.bankproject.user.dto.CustomerDTO;
import com.ironhack.bankproject.user.exception.UserNotFoundException;
import com.ironhack.bankproject.user.model.Admin;
import com.ironhack.bankproject.user.model.Customer;
import com.ironhack.bankproject.user.model.User;
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
        var customerToUpdate= findByUsername(customerDTO.getUsername());
        customerToUpdate.setPassword(customerDTO.getPassword());
        customerToUpdate.setName(customerDTO.getName());
        customerToUpdate.setEmail(customerDTO.getEmail());
        customerToUpdate.setDni(customerDTO.getDni());
        customerToUpdate=customerRepository.save(customerToUpdate);
        return CustomerDTO.fromCustomer(customerToUpdate);
    }



    public CustomerDTO updatePatchMethod(CustomerDTO customerDTO) {
        var customerToUpdate =findByUsername(customerDTO.getUsername());
        if(!customerDTO.getRoles().isEmpty()){
            customerToUpdate.setRoles(customerDTO.getRoles());
        }
        if (!customerToUpdate.getEmail().isEmpty()){
            customerToUpdate.setEmail(customerDTO.getEmail());
        }
        if(!customerToUpdate.getName().isEmpty()){
            customerToUpdate.setName(customerDTO.getName());
        }
        if(!customerToUpdate.getPassword().isEmpty()){
            customerToUpdate.setPassword(customerDTO.getPassword());}
        return CustomerDTO.fromCustomer(customerToUpdate);
    }

    public void delete(CustomerDTO customerDTO) {
        customerRepository.deleteById(customerDTO.getId());
    }

    private Customer findByUsername(String username){
        return customerRepository.findByUsername(username).orElseThrow(()-> new UserNotFoundException(username));
    }
}
