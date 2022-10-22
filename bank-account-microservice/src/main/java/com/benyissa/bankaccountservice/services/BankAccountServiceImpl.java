package com.benyissa.bankaccountservice.services;

import com.benyissa.bankaccountservice.dtos.BankAccountRequestDTO;
import com.benyissa.bankaccountservice.dtos.BankAccountResponseDTO;
import com.benyissa.bankaccountservice.entities.BankAccount;
import com.benyissa.bankaccountservice.exceptions.AccountNotFoundException;
import com.benyissa.bankaccountservice.mappers.BankAccountMapper;
import com.benyissa.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Service
@Transactional
public class BankAccountServiceImpl implements BankAccountService {
    @Autowired
    private BankAccountMapper bankAccountMapper;
    @Autowired
    private BankAccountRepository bankAccountRepository;

    @Override
    public List<BankAccountResponseDTO> listBankAccounts() {
        List list = bankAccountRepository.findAll().stream().map(bankAccountMapper::fromBankAccountToBankAccountResponseDTO).collect(Collectors.toList());
        return list;
    }

    @Override
    public BankAccountResponseDTO findById(String id) {
        return bankAccountMapper.fromBankAccountToBankAccountResponseDTO(bankAccountRepository.findById(id).get());

    }

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccountToSave = bankAccountMapper.frombankAccountRequestDTOTOBankAccount(bankAccountRequestDTO);
        bankAccountToSave.setId(UUID.randomUUID().toString());
        bankAccountToSave.setCreatedAt(new Date());
        BankAccountResponseDTO bankAccountResponseDTO = bankAccountMapper.fromBankAccountToBankAccountResponseDTO(bankAccountRepository.save(bankAccountToSave));
        return bankAccountResponseDTO;
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO) {
        BankAccount bankAccountToSave = bankAccountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
        bankAccountToSave.setAccountType(bankAccountRequestDTO.getAccountType());
        bankAccountToSave.setBalance(bankAccountRequestDTO.getBalance());
        bankAccountToSave.setCurrency(bankAccountRequestDTO.getCurrency());
        bankAccountMapper.frombankAccountRequestDTOTOBankAccount(bankAccountRequestDTO);
        BankAccountResponseDTO bankAccountResponseDTO = bankAccountMapper.fromBankAccountToBankAccountResponseDTO(bankAccountRepository.save(bankAccountToSave));
        return bankAccountResponseDTO;
    }

}
