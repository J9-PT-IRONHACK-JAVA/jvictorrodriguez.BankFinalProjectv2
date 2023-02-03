package com.ironhack.bankproject.transaction.model;

import com.ironhack.bankproject.transaction.enums.TransactionType;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@AllArgsConstructor
public class Transfer extends Transaction{

    private String SenderName;
    private String TargetName;
    private TransactionType transactionType;
    private String observations;

    public Transfer() {
        transactionType=TransactionType.TRANSFER;
    }
}
