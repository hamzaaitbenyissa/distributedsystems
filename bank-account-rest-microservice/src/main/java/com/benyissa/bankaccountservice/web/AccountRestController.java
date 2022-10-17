package com.benyissa.bankaccountservice.web;

import com.benyissa.bankaccountservice.entities.BankAccount;
import com.benyissa.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class AccountRestController {

    final BankAccountRepository bankAccountRepository;

    public AccountRestController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @GetMapping("bankAccounts")
    public List<BankAccount> bankAccounts() {
        return bankAccountRepository.findAll();
    }

    @GetMapping("bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id) {
        return bankAccountRepository.findById(id).get();
    }

    @DeleteMapping("bankAccounts/{id}")
    public BankAccount deleteBankAccount(@PathVariable String id) {
        return bankAccountRepository.findById(id).get();
    }

    @PostMapping("bankAccounts")
    public BankAccount save(BankAccount bankAccount) {
        bankAccount.setId(UUID.randomUUID().toString());
        return bankAccountRepository.save(bankAccount);
    }

    @PutMapping("bankAccounts/{id}")
    public BankAccount update(@PathVariable String id, @RequestBody BankAccount bankAccount) {
        BankAccount bankAccount1 = bankAccountRepository.findById(id).get();
        bankAccount1.setBalance(bankAccount.getBalance());
        bankAccount1.setCurrency(bankAccount.getCurrency());
        return bankAccountRepository.save(bankAccount1);
    }


}
