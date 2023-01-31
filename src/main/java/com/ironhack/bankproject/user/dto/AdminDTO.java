package com.ironhack.bankproject.user.dto;

import com.ironhack.bankproject.user.model.Admin;
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
    @Size(min = 6, max = 8, message = "Size between 6 and 8 characters")
    private String password;
    @Email(message = "Email should be valid")
    private String email;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    private Long id;
    private String roles;

    public AdminDTO(String username, String password, String email, String name, String roles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.roles = roles;
    }

    public static AdminDTO fromAdmin(Admin admin) {
        var adminDTO = new AdminDTO();
        adminDTO.setId(admin.getId());
        adminDTO.setUsername(admin.getUsername());
        adminDTO.setPassword(admin.getPassword());
        adminDTO.setName(admin.getName());
        adminDTO.setEmail(admin.getEmail());
        adminDTO.setRoles(admin.getRoles());
        return adminDTO;
    }
}
