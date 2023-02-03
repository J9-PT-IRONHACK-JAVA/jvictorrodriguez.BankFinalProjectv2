package com.ironhack.bankproject.transaction.model;

import com.ironhack.bankproject.transaction.enums.TransactionType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cash extends Transaction {

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;

}
