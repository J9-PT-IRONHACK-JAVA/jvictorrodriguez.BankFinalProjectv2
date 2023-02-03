package com.ironhack.bankproject.transaction.dto;

import com.ironhack.bankproject.Money;
import com.ironhack.bankproject.transaction.enums.TransactionType;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CashDTO {
    @NotNull
    private Long accountFrom;
    @Embedded
    private Money amount;

    @Enumerated (EnumType.STRING)
    private TransactionType transactionType;

}
