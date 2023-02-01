package com.ironhack.bankproject.account.model;

import com.ironhack.bankproject.Money;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class StudentAccount extends Account{
    private final BigDecimal PENALTY_FEE=BigDecimal.valueOf(40);
    private final BigDecimal MINIMUM_BALANCE=BigDecimal.ZERO;
    private final BigDecimal MONTHLY_MAINTENANCE=BigDecimal.ZERO;
    private final String description="STUDENT ACCOUNT";


    public StudentAccount() {
        setDescription(description);
        setMinimumBalance(new Money(MINIMUM_BALANCE));
        setMonthlyMaintenance(new Money(MONTHLY_MAINTENANCE));
        setPenaltyFee(new Money(PENALTY_FEE));
    }

}
