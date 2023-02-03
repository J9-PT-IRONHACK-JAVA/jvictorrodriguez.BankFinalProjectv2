package com.ironhack.bankproject.account.exceptions;


public class BothAccountAreEqualsException extends RuntimeException {
    public BothAccountAreEqualsException() {
        super("Sender account and Target account are the same");
    }
}
