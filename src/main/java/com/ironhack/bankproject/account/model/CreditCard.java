package com.ironhack.bankproject.account.model;

import com.ironhack.bankproject.Money;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class CreditCard extends Account{
    private final BigDecimal DEFAULT_MIN_CREDIT =new BigDecimal("100");
    private final BigDecimal DEFAULT_MAX_CREDIT =new BigDecimal("100000");
    private final double DEFAULT_INTEREST=0.2;
    private final double MINIMUM_INTEREST=0.1;
    private final BigDecimal PENALTY_FEE=new BigDecimal("40");
    @Column(insertable=false, updatable=false)
    private final String DESCRIPTION="CREDITCARD";
    private BigDecimal credit;

    private double interestRateCred;

    public CreditCard(double interestRateCred) {
          setDescription(DESCRIPTION);
          credit=DEFAULT_MIN_CREDIT;
        if(interestRateCred>DEFAULT_INTEREST) {
            this.interestRateCred = DEFAULT_INTEREST;
        } else if (interestRateCred < MINIMUM_INTEREST) {
            this.interestRateCred=MINIMUM_INTEREST;
        } else {
            this.interestRateCred = interestRateCred;
        }

    }
    public CreditCard() {
        setDescription(DESCRIPTION);
        credit=DEFAULT_MIN_CREDIT;
        setPenaltyFee(new Money(PENALTY_FEE));
        interestRateCred=DEFAULT_INTEREST;
    }

//    public void setCredit(BigDecimal credit) {
//        this.credit = credit;
//    }
}
