package com.benyissa.commonapi.commandes;

import lombok.Getter;

public class CreditAccountCommand extends BaseCommand<String>{
 @Getter
 private final double ammount;
 @Getter
 private final String currency;

    public CreditAccountCommand(String id, double ammount, String currency) {

        super(id);
        this.ammount = ammount;
        this.currency = currency;
    }
}
