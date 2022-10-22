package com.benyissa.bankaccountservice.web;

import com.benyissa.bankaccountservice.dtos.BankAccountRequestDTO;
import com.benyissa.bankaccountservice.dtos.BankAccountResponseDTO;
import com.benyissa.bankaccountservice.entities.BankAccount;
import com.benyissa.bankaccountservice.exceptions.AccountNotFoundException;
import com.benyissa.bankaccountservice.repositories.BankAccountRepository;
import com.benyissa.bankaccountservice.services.BankAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class AccountGraphQlControlle {

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Autowired
    BankAccountService bankAccountService;

    //find all accounts
    @QueryMapping
    List<BankAccount> accountList() {
        return bankAccountRepository.findAll();
    }

    //find an account by id :
    @QueryMapping
    BankAccount accountById(@Argument String id) {
        return bankAccountRepository.findById(id)
                .orElseThrow(() -> new AccountNotFoundException(id));
    }

    //    add an account
    @MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount) {
        return bankAccountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount) {
        return bankAccountService.updateAccount(id,bankAccount);
    }

}
