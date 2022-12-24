package com.benyissa.commonapi.events;

import com.benyissa.commonapi.enums.AccountStatus;
import lombok.Getter;

public class AccountCreatedEvent extends BaseEvent<String> {

    @Getter
    private final double initialBalance;
    @Getter
    private final String currency;
    @Getter
    private final AccountStatus status;

    public AccountCreatedEvent(String id, double initialBalance, String currency, AccountStatus status) {
        super(id);
        this.initialBalance = initialBalance;
        this.currency = currency;
        this.status = status;
    }
}
