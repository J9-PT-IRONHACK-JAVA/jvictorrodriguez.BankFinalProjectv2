package com.ironhack.bankproject.account.exceptions;

import com.ironhack.bankproject.account.enums.AccountType;
import org.springframework.http.converter.HttpMessageNotReadableException;

public class ErrorInJsonInputNotFoundException extends RuntimeException {
    public ErrorInJsonInputNotFoundException(HttpMessageNotReadableException ex) {
        super("Error in Json "+ex);
    }

}
