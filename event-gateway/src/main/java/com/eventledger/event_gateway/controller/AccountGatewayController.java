package com.eventledger.event_gateway.controller;

import com.eventledger.event_gateway.service.AccountGatewayService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountGatewayController {

    private final AccountGatewayService service;

    public AccountGatewayController(AccountGatewayService service) {
        this.service = service;
    }

    @GetMapping("/health")
    public String health() {
        return "Gateway Running";
    }

    @GetMapping("/accounts")
    public String accounts() {
        return service.getAccounts();
    
    }

    @GetMapping("/accounts/{id}")
    public String accountById(@PathVariable Long id) {
        return service.getAccountById(id);
    }
}