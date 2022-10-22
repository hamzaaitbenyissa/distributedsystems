package com.benyissa.bankaccountservice.dtos;

import com.benyissa.bankaccountservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountResponseDTO {
    private String id;
    private Date createdAt;
    private double balance;
    private String currency;
    private AccountType accountType;
}
