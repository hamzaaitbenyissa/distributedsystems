package com.benyissa.bankaccountservice.dto;

import com.benyissa.bankaccountservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

//search for builder
@Builder
public class BankAccountResponseDTO {
    private double balance;
    private String currency;
    private AccountType accountType;
}
