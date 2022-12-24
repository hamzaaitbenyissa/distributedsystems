package com.benyissa.queries.services;

import com.benyissa.commonapi.events.AccountActivatedEvent;
import com.benyissa.commonapi.events.AccountCreatedEvent;
import com.benyissa.commonapi.events.AccountDebitedEvent;
import com.benyissa.commonapi.queries.GetAccountById;
import com.benyissa.commonapi.queries.GetAllAccountQuery;
import com.benyissa.queries.entities.Account;
import com.benyissa.queries.repositories.AccountRepository;
import com.benyissa.queries.repositories.OperationRepository;
import com.benyissa.commonapi.enums.OperationType;
import com.benyissa.commonapi.events.AccountCreditedEvent;
import com.benyissa.queries.entities.Operation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class AccountServiceHandler {

    AccountRepository accountRepository;
    OperationRepository operationRepository;

    @EventHandler
    @Transactional
    public void on(AccountCreatedEvent event) {
        log.info("===========================");
        log.info("AccountCreatedEvent Received With T" +
                "he Following Infos : ");
        log.info(event.getId());
        log.info(event.getCurrency());
        log.info(event.getInitialBalance() + "");
        log.info("===========================");
        Account account = new Account();

        account.setId(event.getId());
        account.setBalance(event.getInitialBalance());
        account.setCurrency(event.getCurrency());
        account.setStatus(event.getStatus());
        accountRepository.save(account);
    }

    @EventHandler
    @Transactional
    public void on(AccountActivatedEvent event) {
        log.info("===========================");
        log.info("AccountActivatedEvent Received ");
        log.info("===========================");

        Account account = accountRepository.findById(event.getId()).get();
        account.setStatus(event.getStatus());
        accountRepository.save(account);
    }

    @EventHandler
    @Transactional
    public void on(AccountDebitedEvent event) {
        log.info("===========================");
        log.info("AccountDebitedEvent Received ");
        log.info("===========================");

        Operation operation = new Operation();
        Account account = accountRepository.findById(event.getId()).get();
        account.setBalance(account.getBalance() - event.getAmount());

        operation.setDataOperation(new Date());
        operation.setType(OperationType.DEBIT);
        operation.setAmount(event.getAmount());
        operation.setAccount(account);
        operationRepository.save(operation);
        accountRepository.save(account);
    }

    @EventHandler
    @Transactional
    public void on(AccountCreditedEvent event) {
        log.info("===========================");
        log.info("AccountCreditedEvent Received ");
        log.info("===========================");

        Operation operation = new Operation();
        Account account = accountRepository.findById(event.getId()).get();
        account.setBalance(account.getBalance() + event.getAmount());
        operation.setDataOperation(new Date());
        operation.setType(OperationType.CREDIT);
        operation.setAmount(event.getAmount());
        operation.setAccount(account);
        operationRepository.save(operation);
        accountRepository.save(account);
    }

    @QueryHandler
    public List<Account> on(GetAllAccountQuery getAllAccountQuery) {
        return accountRepository.findAll();
    }

    @QueryHandler
    public Account on(GetAccountById getAccountById) {
        return accountRepository.findById(getAccountById.getId()).get();
    }
}
