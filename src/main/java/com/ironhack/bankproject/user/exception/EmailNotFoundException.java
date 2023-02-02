package com.ironhack.bankproject.user.exception;

public class EmailNotFoundException extends RuntimeException {
    public EmailNotFoundException(String username) {
        super("The user with username "+ username +" was not found");
    }
}


