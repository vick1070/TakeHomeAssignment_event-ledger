package com.eventledger.event_gateway.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

@Service
public class AccountGatewayService {

    private final WebClient webClient;

    public AccountGatewayService() {
        this.webClient =
                WebClient.builder()
                        .baseUrl("http://localhost:8081")
                        .build();
    }

    public String getAccounts() {
        return webClient
                .get()
                .uri("/accounts")
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public String getAccountById(Long id) {
        return webClient
                .get()
                .uri("/accounts/" + id)
                .retrieve()
                .onStatus(
                    status -> status.value() == 404,
                    response -> {
                        throw new ResponseStatusException(
                            HttpStatus.NOT_FOUND,
                            "Account not found"
                        );
                    }
                )
                .bodyToMono(String.class)
                .block();
    }
    
    public String getEvents(){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://localhost:8082/events", String.class);
    }
    
}