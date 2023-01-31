package com.ironhack.bankproject.user.model;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@NoArgsConstructor
public class Admin extends User{
    @Email(message = "Email should be valid")
    private String email;
    @NotEmpty (message = "Name cannot be empty")
    private String name;

    public Admin(String username, String password, String roles,
                 String email, String name) {
        super(username, password, roles);
        this.email = email;
        this.name = name;
    }
}
