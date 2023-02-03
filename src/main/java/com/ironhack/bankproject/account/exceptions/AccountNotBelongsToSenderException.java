package com.ironhack.bankproject.account.exceptions;


public class AccountNotBelongsToSenderException extends RuntimeException {
    public AccountNotBelongsToSenderException() {
        super("Account don't belongs to sender customer");
    }
}
