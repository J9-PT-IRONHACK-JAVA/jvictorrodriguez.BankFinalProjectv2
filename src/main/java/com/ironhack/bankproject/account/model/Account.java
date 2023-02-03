package com.ironhack.bankproject.account.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.bankproject.Money;
import com.ironhack.bankproject.account.dto.AccountDTO;
import com.ironhack.bankproject.account.enums.Status;
import com.ironhack.bankproject.user.dto.CustomerDTO;
import com.ironhack.bankproject.user.model.Customer;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    @Embedded
    private Money balance;
    @NotNull
    @Enumerated (EnumType.STRING)
    private Status status;
    @CreationTimestamp
    private Instant creationDate;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "balance_min_currency")),
            @AttributeOverride(name = "amount", column = @Column(name = "balance_min_amount"))})
    private Money minimumBalance;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "monthly_maintenance_currency")),
            @AttributeOverride(name = "amount", column = @Column(name = "monthly_maintenance_amount"))})
    private Money monthlyMaintenance;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "currency", column = @Column(name = "penalty_fee_currency")),
            @AttributeOverride(name = "amount", column = @Column(name = "penalty_fee_amount"))})
    private Money penaltyFee;

    @ManyToMany
    @JoinTable(
            name="accounts_customers",
            joinColumns = @JoinColumn (name = "account_id"),
            inverseJoinColumns = @JoinColumn( name ="customer_id")
    )
    //@JsonIgnore
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

    public static Account fromDTO(AccountDTO accountDTO){
        var account=new Account();
        account.setDescription(accountDTO.getAccountType().toString());
        account.setId(accountDTO.getId());
        return account;
    }
}
