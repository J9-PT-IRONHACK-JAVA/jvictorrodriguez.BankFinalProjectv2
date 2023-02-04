package com.ironhack.bankproject.user.service;

import com.ironhack.bankproject.user.dto.AdminDTO;
import com.ironhack.bankproject.user.dto.CustomerDTO;
import com.ironhack.bankproject.user.exception.UserAlredyExistsException;
import com.ironhack.bankproject.user.exception.UserNotFoundException;
import com.ironhack.bankproject.user.model.Admin;
import com.ironhack.bankproject.user.model.Customer;
import com.ironhack.bankproject.user.model.User;
import com.ironhack.bankproject.user.repository.CustomerRepository;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public CustomerDTO create(@RequestBody @Valid CustomerDTO customerDTO) {
        var customerFound = getByDni(customerDTO);
        if (customerFound.isPresent()) {

            throw new UserAlredyExistsException(customerDTO.getDni());
        }
        var customerNew = Customer.fromDTO(customerDTO);
        customerNew.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
        customerRepository.save(customerNew);
        return CustomerDTO.fromCustomer(customerNew);
    }


    public CustomerDTO update(@RequestBody @Valid CustomerDTO customerDTO) {
        //Looks for the user by username. if it doesn't exist throws an exception
        //else updates all 5 attributes
        var customerToUpdate = findByUsername(customerDTO.getUsername());
        customerToUpdate.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
        customerToUpdate.setName(customerDTO.getName());
        customerToUpdate.setEmail(customerDTO.getEmail());
        customerToUpdate.setDni(customerDTO.getDni());
        customerToUpdate = customerRepository.save(customerToUpdate);
        return CustomerDTO.fromCustomer(customerToUpdate);
    }


    public CustomerDTO updatePatchMethod(CustomerDTO customerDTO) {
        var customerToUpdate = findByUsername(customerDTO.getUsername());



        if (customerDTO.getEmail()!=null) {
            customerToUpdate.setEmail(customerDTO.getEmail());
        }
        if (customerDTO.getName()!=null) {
            customerToUpdate.setName(customerDTO.getName());
        }
        if (customerDTO.getPassword()!=null) {
            customerToUpdate.setPassword(passwordEncoder.encode(customerDTO.getPassword()));
        }
        if (customerDTO.getDOB()!=null) {
            customerToUpdate.setDOB(customerDTO.getDOB());
        }

        customerRepository.save(customerToUpdate);
        return CustomerDTO.fromCustomer(customerToUpdate);
    }

    public void delete(CustomerDTO customerDTO) {
        var customerToDelete = findByUsername(customerDTO.getUsername());

        customerRepository.deleteById(customerToDelete.getId());
    }

    private Customer findByUsername(String username) {
        return customerRepository.findByUsername(username).orElseThrow(() -> new UserNotFoundException(username));
    }

    private Optional<Customer> getByDni(CustomerDTO customerDTO) {
        return customerRepository.findByDni(customerDTO.getDni());
    }
}
