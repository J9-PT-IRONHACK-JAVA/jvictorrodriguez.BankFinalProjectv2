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
    @Column(insertable=false, updatable=false)
    private final BigDecimal MINIMUM_BALANCE= new BigDecimal("250");
    private final BigDecimal MONTHLY_MAINTENANCE_FEE=new BigDecimal("12");
    @Column(insertable=false, updatable=false)
    private final String DESCRIPTION="CHECKING ACCOUNT";


    public CheckingAccount(Money minimumBalance) {
        setDescription(DESCRIPTION);
        setMinimumBalance(new Money(MINIMUM_BALANCE));
        setMonthlyMaintenance(new Money(MONTHLY_MAINTENANCE_FEE));
        setPenaltyFee(new Money(PENALTY_FEE));
    }
    public CheckingAccount() {
        setDescription(DESCRIPTION);
        setMinimumBalance(new Money(MINIMUM_BALANCE));
        setMonthlyMaintenance(new Money(MONTHLY_MAINTENANCE_FEE));
        setPenaltyFee(new Money(PENALTY_FEE));
    }
}
