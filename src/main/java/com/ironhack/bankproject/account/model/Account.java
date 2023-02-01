package com.ironhack.bankproject.account.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.bankproject.Money;
import com.ironhack.bankproject.account.dto.AccountDTO;
import com.ironhack.bankproject.account.enums.Status;
import com.ironhack.bankproject.user.model.Customer;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Embedded
    private Money balance;
    private Status status;
    @CreationTimestamp
    private Instant creationDate;
    @ManyToMany
    @JoinTable(
            name="accounts_customers",
            joinColumns = @JoinColumn (name = "account_id"),
            inverseJoinColumns = @JoinColumn( name ="customer_id")
    )
    @JsonIgnore
    private Set<Customer> owners= new HashSet<>();

    public Account() {
        this.balance= new Money(BigDecimal.ZERO);
        this.status=Status.ACTIVE;
    }

    public Account(String description) {
        this.description = description;
        this.balance= new Money(BigDecimal.ZERO);
        this.status=Status.ACTIVE;
    }

    public void addOwners(List<Customer> customers){
        owners.addAll(customers);
    }

    public static Account fromDTO(AccountDTO AccountDTO){

        return new CheckingAccount();
    }

}
