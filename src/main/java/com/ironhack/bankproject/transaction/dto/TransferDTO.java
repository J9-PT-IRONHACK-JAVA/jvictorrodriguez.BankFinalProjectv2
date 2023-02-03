package com.ironhack.bankproject.transaction.dto;

import com.ironhack.bankproject.Money;
import jakarta.persistence.Embedded;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferDTO {


    private Long accountFrom;

    private Long accountTo;
    @Embedded
    private Money amount;
    @NotBlank(message = "Name is mandatory")
    private String TargetName;
    private String observations;

    private String senderId;

    // private TransactionType transactionType; // it's a transfer
    //private String SenderName; //from the system

}
