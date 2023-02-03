package com.ironhack.bankproject.account.exceptions;


public class FraudDetectionException extends RuntimeException {
    public FraudDetectionException(String message) {
        super(message);
    }
}
