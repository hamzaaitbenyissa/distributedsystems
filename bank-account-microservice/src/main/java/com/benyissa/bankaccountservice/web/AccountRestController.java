package com.benyissa.bankaccountservice.web;

import com.benyissa.bankaccountservice.dtos.BankAccountRequestDTO;
import com.benyissa.bankaccountservice.dtos.BankAccountResponseDTO;
import com.benyissa.bankaccountservice.mappers.BankAccountMapper;
import com.benyissa.bankaccountservice.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountRestController {


    final
    BankAccountService bankAccountService;

    final BankAccountMapper bankAccountMapper;

    public AccountRestController(BankAccountMapper bankAccountMapper, BankAccountService bankAccountService) {
        this.bankAccountMapper = bankAccountMapper;
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/bankAccounts")
    public List<BankAccountResponseDTO> bankAccounts() {
        return bankAccountService.listBankAccounts();
    }


    @GetMapping("bankAccounts/{id}")
    public BankAccountResponseDTO bankAccount(@PathVariable String id) {
        return bankAccountService.findById(id);
    }

    @DeleteMapping("bankAccounts/{id}")
    public BankAccountResponseDTO deleteBankAccount(@PathVariable String id) {
        return bankAccountService.findById(id);
    }

    @PostMapping("bankAccounts")
    public BankAccountResponseDTO save(BankAccountRequestDTO bankAccountRequestDTO) {
        return bankAccountService.addAccount(bankAccountRequestDTO);
    }

    @PutMapping("bankAccounts/{id}")
    public BankAccountResponseDTO update(@PathVariable String id, @RequestBody BankAccountRequestDTO bankAccount) {
        return bankAccountService.updateAccount(id, bankAccount);
    }


}
