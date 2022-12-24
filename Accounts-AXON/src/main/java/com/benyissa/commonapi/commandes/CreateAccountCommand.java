package com.benyissa.commonapi.commandes;

import lombok.Getter;

public class CreateAccountCommand extends BaseCommand<String>{
 @Getter
 private final double initialBalance;
 @Getter
 private final String currency;

    public CreateAccountCommand(String id, double initialBalance, String currency) {
        super(id);
        this.initialBalance = initialBalance;
        this.currency = currency;
    }
}
