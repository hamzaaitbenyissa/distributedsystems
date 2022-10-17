package com.benyissa.bankaccountservice.services;

import com.benyissa.bankaccountservice.dto.BankAccountRequestDTO;
import com.benyissa.bankaccountservice.dto.BankAccountResponseDTO;

public interface AccountService {


    BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);

}
