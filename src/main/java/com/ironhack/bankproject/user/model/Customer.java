package com.ironhack.bankproject.user.model;

import com.ironhack.bankproject.user.dto.CustomerDTO;
import com.ironhack.bankproject.user.enums.Roles;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity

public class Customer extends User{
    @Size(min = 6,max=9,message = "Dni should have between 6 and 9 characters")
    @Column (unique = true)
    private String dni;
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    private String dOB;

    @Embedded
    private Address address;


    public Customer() {

    }

    public Customer(String dni, String name, String dOB, Address address) {
        this.dni = dni;
        this.name = name;
        this.dOB = dOB;
        this.address = address;
    }

    public static Customer fromDTO(CustomerDTO customerDTO){
        var customer= new Customer();
        customer.setPassword(customerDTO.getPassword());
        customer.setEmail(customerDTO.getEmail());
        customer.setName(customerDTO.getName());
        customer.setId(customerDTO.getId());
        customer.setDni(customerDTO.getDni());
        customer.setDOB(customerDTO.getDOB());
        customer.setAddress(customerDTO.getAddress());
        return customer;
    }

}
