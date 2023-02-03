package com.ironhack.bankproject.transaction.dto;

import com.ironhack.bankproject.Money;
import com.ironhack.bankproject.transaction.enums.TransactionType;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {


    @NotNull
    private Long accountFrom;
    private Long accountTo;
    @Embedded
    private Money amount;
    @NotBlank(message = "Name is mandatory")
    private String TargetName;
    private String observations;

    private String senderId;


    @Enumerated(EnumType.STRING)
    private TransactionType transactionType;


    //private String SenderName; //from the system




}
