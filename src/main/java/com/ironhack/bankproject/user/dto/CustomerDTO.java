package com.ironhack.bankproject.user.dto;

import com.ironhack.bankproject.user.enums.Roles;
import com.ironhack.bankproject.user.model.Address;
import com.ironhack.bankproject.user.model.Customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class CustomerDTO {
    @NotEmpty(message = "Username cannot be empty")
    private String username;
    @Size(min = 6, max = 8, message = "Size between 6 and 8 characters")
    private String password;
    @Size(min = 6, max = 9, message = "Dni should have between 6 and 9 characters")
    private String dni;
    @Email(message = "Email should be valid")
    private String email;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @Pattern(regexp = "^(0?[1-9]|[12][0-9]|3[01])[\\/\\-](0?[1-9]|1[012])[\\/\\-]\\d{4}$",message = "format-> dd/MM/yyyy")
    private String dOB;
    private Address address;
    private Long id;
    private Roles roles;

    public CustomerDTO() {
        this.roles=Roles.USER;
    }

    public CustomerDTO(String username, String password,
                       String dni, String email, String name) {
        this.username = username;
        this.password = password;
        this.dni = dni;
        this.email = email;
        this.name = name;
        this.dOB=dOB;
        this.address=getAddress();
        this.roles = Roles.USER;
    }

    public static CustomerDTO fromCustomer(Customer customer) {
        var customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setUsername(customer.getUsername());
        customerDTO.setPassword(customer.getPassword());
        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setDni(customer.getDni());
        customerDTO.setAddress(customer.getAddress());
        customerDTO.setDOB(customer.getDOB());
        return customerDTO;
    }
}
