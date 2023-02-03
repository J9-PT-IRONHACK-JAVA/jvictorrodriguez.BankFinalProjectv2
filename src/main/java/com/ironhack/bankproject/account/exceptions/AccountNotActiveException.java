package com.ironhack.bankproject.account.exceptions;


public class AccountNotActiveException extends RuntimeException {
    public AccountNotActiveException(String accountOwner) {
        super("Account "+accountOwner + " isn't ACTIVE");
    }
}
