package com.benyissa.bankaccountservice.exceptions;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(String id) {
        super(String.format("account %s not found ", id));
    }
}
