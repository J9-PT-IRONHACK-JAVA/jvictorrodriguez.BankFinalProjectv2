package com.ironhack.bankproject.User.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Data
@Entity
@Table(name = "users")
public class user {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private String username;
    private String password;
    private String roles;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialNonExpired;
    private boolean isEnabled;
    @CreationTimestamp
    private Instant creationDate;
    @UpdateTimestamp
    private Instant updateDate;

}
