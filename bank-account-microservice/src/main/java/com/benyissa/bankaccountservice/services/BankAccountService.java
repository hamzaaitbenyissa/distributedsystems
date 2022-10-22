package com.benyissa.bankaccountservice.services;

import com.benyissa.bankaccountservice.dtos.BankAccountRequestDTO;
import com.benyissa.bankaccountservice.dtos.BankAccountResponseDTO;

import java.util.List;

public interface BankAccountService {

    List<BankAccountResponseDTO> listBankAccounts();
    BankAccountResponseDTO findById(String id);
    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);

}
