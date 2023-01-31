package com.ironhack.bankproject.user.model;

import com.ironhack.bankproject.user.dto.AdminDTO;
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
    public static Admin fromDTO(AdminDTO adminDTO){
        var admin=new Admin();
        admin.setUsername(adminDTO.getUsername());
        admin.setPassword(adminDTO.getPassword());
        admin.setEmail(adminDTO.getEmail());
        admin.setName(adminDTO.getName());
        admin.setId(adminDTO.getId());
        admin.setRoles(adminDTO.getRoles());
        return admin;
    }
}
