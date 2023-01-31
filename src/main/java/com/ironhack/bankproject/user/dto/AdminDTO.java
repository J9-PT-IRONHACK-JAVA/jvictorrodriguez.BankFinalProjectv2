package com.ironhack.bankproject.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDTO {
    @NotEmpty(message = "Username cannot be empty")
    private String username;
    @Size (min = 6, max = 8,message = "Size between 6 and 8 characters")
    private String password;
    @Email( message = "Email should be valid")
    private String email;
    @NotEmpty (message = "Name cannot be empty")
    private String name;
    private Long id;
}
