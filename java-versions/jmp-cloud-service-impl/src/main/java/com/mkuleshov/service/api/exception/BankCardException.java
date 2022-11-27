package com.mkuleshov.service.api.exception;

public class BankCardException extends RuntimeException{
    public BankCardException() {
        super("Bank card doesn't exist.");
    }
}
