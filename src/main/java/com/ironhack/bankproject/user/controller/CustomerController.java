package com.ironhack.bankproject.user.controller;

import com.ironhack.bankproject.user.dto.CustomerDTO;
import com.ironhack.bankproject.user.model.Customer;
import com.ironhack.bankproject.user.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/AdminAcces/Customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("FindAll")
    public List<Customer> findAll(){
        return customerService.findAll();
    }
    @PostMapping("Create")
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO create(@RequestBody @Valid CustomerDTO customerDTO){
        return customerService.create(customerDTO);
    }
    @PutMapping("Update")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO updatePutMethod(@RequestBody @Valid CustomerDTO customerDTO){
        return customerService.update(customerDTO);
    }

    @PatchMapping("Update")
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO updatePatchMethod(@RequestBody CustomerDTO customerDTO){
        return customerService.updatePatchMethod(customerDTO);
    }

    @DeleteMapping("Delete")
    public void delete(@RequestBody CustomerDTO customerDTO){
        customerService.delete(customerDTO);
    }
}
