package com.ironhack.bankproject.account.exceptions;


public class AccountIdNotFoundException extends RuntimeException {
    public AccountIdNotFoundException(Long id) {
        super("The Account id "+ id + " was not found");
    }
}
