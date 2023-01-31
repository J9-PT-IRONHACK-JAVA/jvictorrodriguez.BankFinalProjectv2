package com.ironhack.bankproject.user.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String username) {
        super("The user with username "+ username +" was not found");
    }
}
