package com.ironhack.bankproject.transaction.dto;

import com.ironhack.bankproject.Money;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferDTO {

    @NotEmpty
    private Long accountFrom;
    @NotEmpty
    private Long accountTo;
    @Embedded
    private Money amount;
    @NotEmpty
    private String TargetName;
    private String observations;
    @NotEmpty
    private String senderId;

    // private TransactionType transactionType; // it's a transfer
    //private String SenderName; //from the system

}
