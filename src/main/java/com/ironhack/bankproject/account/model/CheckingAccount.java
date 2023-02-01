package com.ironhack.bankproject.account.model;

import com.ironhack.bankproject.Money;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;


@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class CheckingAccount extends Account{
    private final BigDecimal PENALTY_FEE= new BigDecimal("40");
    private final BigDecimal MINIMUM_BALANCE= new BigDecimal("250");
    private final BigDecimal MONTHLY_MAINTENANCE_FEE=new BigDecimal("12");
    private final String description="CHECKING ACCOUNT";

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

    public CheckingAccount(Money minimumBalance) {
        setDescription(description);
        setMinimumBalance(minimumBalance);
        this.monthlyMaintenance = new Money(MONTHLY_MAINTENANCE_FEE);
    }
    public CheckingAccount() {
        setDescription(description);
        this.minimumBalance = new Money(MINIMUM_BALANCE);
        this.monthlyMaintenance = new Money(MONTHLY_MAINTENANCE_FEE);
    }
}
