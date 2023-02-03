package com.ironhack.bankproject.account.exceptions;


public class AmountNotPositiveException extends RuntimeException {
    public AmountNotPositiveException() {
        super("Amount must be positive");
    }
}
