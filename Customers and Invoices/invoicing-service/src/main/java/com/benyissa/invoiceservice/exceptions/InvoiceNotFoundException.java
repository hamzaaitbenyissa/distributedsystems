package com.benyissa.invoiceservice.exceptions;

public class InvoiceNotFoundException extends RuntimeException {

    public InvoiceNotFoundException(String id) {
        super(String.format("invoice with id = %s not found", id));
    }
}
