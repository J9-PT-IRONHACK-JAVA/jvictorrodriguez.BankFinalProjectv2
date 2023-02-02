package com.ironhack.bankproject.advice;

import com.ironhack.bankproject.user.exception.UserAlredyExistsException;
import com.ironhack.bankproject.user.exception.EmailNotFoundException;
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
    @ExceptionHandler(EmailNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String usernameNotFoundHandler(EmailNotFoundException ex){
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


}
