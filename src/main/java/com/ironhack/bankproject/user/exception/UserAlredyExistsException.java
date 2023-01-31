package com.ironhack.bankproject.user.exception;

public class UserAlredyExistsException extends Throwable {
    public UserAlredyExistsException(String username) {
        super("User "+username + " exists already in the system");
    }
}
