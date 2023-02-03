package com.ironhack.bankproject.transaction.fraud;

import com.ironhack.bankproject.account.enums.Status;
import com.ironhack.bankproject.account.exceptions.FraudDetectionException;
import com.ironhack.bankproject.account.repository.AccountRepository;
import com.ironhack.bankproject.transaction.dto.TransactionDTO;
import com.ironhack.bankproject.transaction.validation.ValidationTransaction;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class FraudDetection {

    private final AccountRepository accountRepository;
    private final ValidationTransaction validationTransaction;
    public void checkFraud(TransactionDTO transactionDTO){
        var accountId=transactionDTO.getAccountFrom();
        var account = validationTransaction.findAccountById(accountId);
        account.setStatus(Status.FROZEN);
        throw new FraudDetectionException("Fraud Detection. Account FROZEN for Security");


    }
}
