package com.benyissa.costumerservice.exceptions;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(String id) {
        super(String.format("customer with id = %s not found", id));
    }
}
