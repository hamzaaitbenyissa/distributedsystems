package com.benyissa.commonapi.events;

import lombok.Getter;

public class AccountCreditedEvent extends BaseEvent<String> {
    @Getter
    private final double amount;
    @Getter
    private final String currency;
    public AccountCreditedEvent(String id, double amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
    }
}
