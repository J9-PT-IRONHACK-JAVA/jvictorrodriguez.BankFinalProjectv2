package com.ironhack.bankproject.advice;

import com.ironhack.bankproject.account.exceptions.*;
import com.ironhack.bankproject.user.exception.UserAlredyExistsException;
import com.ironhack.bankproject.user.exception.UserNotFoundException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class BankControllerAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class) // MethodArgumentNotValidException
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleNotValidExceptions(MethodArgumentNotValidException ex) {
        var errors = new HashMap<String, String>();
        ex.getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String usernameNotFoundHandler(UserNotFoundException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(UserAlredyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String usernameAlreadyExistsHandler(UserAlredyExistsException ex){
        return ex.getMessage();
    }
    @ExceptionHandler(EmptyResultDataAccessException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String emptyResultDataAccessHandler(EmptyResultDataAccessException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String errorInJsonInput(HttpMessageNotReadableException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(AccountIdNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String accountIdNotFound(AccountIdNotFoundException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(CannotCancelAnAccountWithBalanceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String existsBalanceInAccountToDelete(CannotCancelAnAccountWithBalanceException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(BothAccountAreEqualsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String bothAccountsAreEqualsException(BothAccountAreEqualsException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(AmountNotPositiveException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String amountNotPositiveException(AmountNotPositiveException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(AccountNotActiveException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String AccountNotActiveException(AccountNotActiveException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(InsufficientBalanceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String insufficientBalanceException(InsufficientBalanceException ex){
        return ex.getMessage();
    }


    @ExceptionHandler(AccountNotBelongsToSenderException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String accountNotBelongsToSenderException(AccountNotBelongsToSenderException ex){
        return ex.getMessage();
    }

    @ExceptionHandler(FraudDetectionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String accountNotBelongsToSenderException(FraudDetectionException ex){
        return ex.getMessage();
    }
}
