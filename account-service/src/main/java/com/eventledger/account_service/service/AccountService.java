package com.eventledger.account_service.service;

import com.eventledger.account_service.entity.Account;
import com.eventledger.account_service.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public Account create(Account account) {
        return repository.save(account);
    }

    public List<Account> getAll() {
        return repository.findAll();
    }

    public Account getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> 
                new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Account not found"
                ));
    }
}