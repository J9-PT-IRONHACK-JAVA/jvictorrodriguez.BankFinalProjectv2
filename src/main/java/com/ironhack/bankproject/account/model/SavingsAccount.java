package com.ironhack.bankproject.account.model;

import com.ironhack.bankproject.Money;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class SavingsAccount extends Account {

    private final double MAXIMUM_INTEREST_RATE= 0.5;
    @Column(insertable=false, updatable=false)
    private final double DEFAULT_INTEREST_RATE= 0.0025;
    private final BigDecimal MINIMUM_BALANCE= new BigDecimal("100");
    @Column(insertable=false, updatable=false)
    private final BigDecimal DEFAULT_MINIMUM_BALANCE=new BigDecimal("1000");
    private final BigDecimal MONTHLY_MAINTENANCE_FEE=BigDecimal.ZERO;
    private final BigDecimal PENALTY_FEE= new BigDecimal("40");
    @Column(insertable=false, updatable=false)
    private final String DESCRIPTION="SAVINGS";

private double interestRate;


    public SavingsAccount(double interestRate, Money minimumBalance) {
        setDescription(DESCRIPTION);
        if (interestRate>getDEFAULT_INTEREST_RATE())
            this.interestRate = getDEFAULT_INTEREST_RATE();
        else
            this.interestRate=interestRate;
        //If the DEFAULT_MINIMUM_BALANCE IS LOWER ..
        if(DEFAULT_MINIMUM_BALANCE.compareTo(minimumBalance.getAmount()) < 0)
            setMinimumBalance(new Money(getDEFAULT_MINIMUM_BALANCE()));
        else
            setMinimumBalance(new Money(DEFAULT_MINIMUM_BALANCE));
    }

    public SavingsAccount() {
        setDescription(DESCRIPTION);
        this.interestRate = getDEFAULT_INTEREST_RATE();
        setMinimumBalance(new Money(getDEFAULT_MINIMUM_BALANCE()));

    }
}
