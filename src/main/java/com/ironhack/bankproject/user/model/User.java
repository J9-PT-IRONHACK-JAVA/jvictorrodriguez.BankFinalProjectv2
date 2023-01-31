package com.ironhack.bankproject.user.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@Data
@Entity
@Table(name = "users")
public abstract class  User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (unique = true)
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

    public User(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.isAccountNonExpired=true;
        this.isAccountNonLocked=true;
        this.isCredentialNonExpired=true;
        this.isEnabled=true;
    }

    public User() {
        this.isAccountNonExpired=true;
        this.isAccountNonLocked=true;
        this.isCredentialNonExpired=true;
        this.isEnabled=true;
    }
}
//todo java.sql.SQLIntegrityConstraintViolationException: Duplicate entry '12345i' for key 'users.UK_r43af9ap4edm43mmtq01oddj6'