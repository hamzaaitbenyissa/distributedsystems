package com.benyissa.commonapi.commandes;

import lombok.Getter;

public class DebitAccountCommand extends BaseCommand<String>{
 @Getter
 private final double amount;
 @Getter
 private final String currency;

    public DebitAccountCommand(String id, double amount, String currency) {
        super(id);
        this.amount = amount;
        this.currency = currency;
    }
}
