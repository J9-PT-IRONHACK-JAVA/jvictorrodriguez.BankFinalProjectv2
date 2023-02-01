package com.ironhack.bankproject.account.model;

import com.ironhack.bankproject.Money;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class StudentAccount extends Account{
    private final BigDecimal PENALTY_FEE=BigDecimal.valueOf(40);
    private final BigDecimal MINIMUM_BALANCE=BigDecimal.ZERO;
    private final BigDecimal MONTHLY_MAINTENANCE=BigDecimal.ZERO;
    private final String description="STUDENT ACCOUNT";

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

    public StudentAccount() {
        setDescription(description);
        this.minimumBalance = new Money(MINIMUM_BALANCE);
        this.monthlyMaintenance = new Money(MONTHLY_MAINTENANCE);
        this.penaltyFee = new Money(PENALTY_FEE);
    }
}
