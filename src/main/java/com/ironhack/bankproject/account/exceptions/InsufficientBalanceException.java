package com.ironhack.bankproject.account.exceptions;


public class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException() {
        super("The account has insufficient Balance to the transaction");
    }
}
