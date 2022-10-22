package com.benyissa.bankaccountservice;

import com.benyissa.bankaccountservice.dtos.BankAccountRequestDTO;
import com.benyissa.bankaccountservice.enums.AccountType;
import com.benyissa.bankaccountservice.services.BankAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankAccountServiceApplication {

    final BankAccountService bankAccountService;

    public BankAccountServiceApplication(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    public static void main(String[] args) {
        SpringApplication.run(BankAccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            BankAccountRequestDTO bankAccountRequestDTO= new BankAccountRequestDTO(12.3,"USD", AccountType.CURRENT_ACCOUNT);
            System.out.println(bankAccountRequestDTO.getCurrency());
            bankAccountService.addAccount(bankAccountRequestDTO);
        };
    }
}
