package com.ironhack.bankproject.account.exceptions;


public class CannotCancelAnAccountWithBalanceException extends RuntimeException {
    public CannotCancelAnAccountWithBalanceException(Long id) {
        super("The are balance in the Account id "+ id );
    }
}
