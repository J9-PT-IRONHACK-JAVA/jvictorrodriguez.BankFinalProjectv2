package com.ironhack.bankproject.user.model;

import com.ironhack.bankproject.user.dto.CustomerDTO;
import jakarta.persistence.Column;
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
    @Email(message = "Email should be valid")
    private String email;
    @NotEmpty(message = "Name cannot be empty")
    private String name;

    public Customer() {
        this.setRoles("ROLE_USER");
    }

    public Customer(String username, String password, String roles,
                    String dni, String email, String name) {
        super(username, password, roles);
        this.dni = dni;
        this.email = email;
        this.name = name;
        this.setRoles("ROLE_USER");
    }

    public static Customer fromDTO(CustomerDTO customerDTO){
        var customer= new Customer();
        customer.setUsername(customerDTO.getUsername());
        customer.setPassword(customerDTO.getPassword());
        customer.setEmail(customerDTO.getEmail());
        customer.setName(customerDTO.getName());
        customer.setId(customerDTO.getId());
        customer.setDni(customerDTO.getDni());
        return customer;
    }

}
