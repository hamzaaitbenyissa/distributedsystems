package com.benyissa.bankaccountservice.services;

import com.benyissa.bankaccountservice.dto.BankAccountRequestDTO;
import com.benyissa.bankaccountservice.dto.BankAccountResponseDTO;
import com.benyissa.bankaccountservice.entities.BankAccount;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional

public class AccountServiceImpl implements AccountService {

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccount = BankAccount.builder().build();

        bankAccount.setBalance(bankAccountRequestDTO.getBalance());
        bankAccount.setCurrency(bankAccountRequestDTO.getCurrency());
        bankAccount.setAccountType(bankAccountRequestDTO.getAccountType());

        return null;
    }

}
