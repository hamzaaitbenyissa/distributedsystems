package com.benyissa.bankaccountservice.dtos;

import com.benyissa.bankaccountservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BankAccountRequestDTO {
    private double balance;
    private String currency;
    private AccountType accountType;
}
