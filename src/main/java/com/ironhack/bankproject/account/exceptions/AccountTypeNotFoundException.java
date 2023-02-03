package com.ironhack.bankproject.account.exceptions;

import com.ironhack.bankproject.account.enums.AccountType;


public class AccountTypeNotFoundException extends RuntimeException {
    public AccountTypeNotFoundException(AccountType accountType) {
        super("The Account Type "+accountType + " doesn't exist");
    }
}
