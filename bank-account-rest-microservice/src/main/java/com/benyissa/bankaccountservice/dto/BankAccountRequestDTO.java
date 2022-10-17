package com.benyissa.bankaccountservice.dto;

import com.benyissa.bankaccountservice.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

//search for builder
@Builder
public class BankAccountRequestDTO {
    private double balance;
    private String currency;
    private AccountType accountType;
}
