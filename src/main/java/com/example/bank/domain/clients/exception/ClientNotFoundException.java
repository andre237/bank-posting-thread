package com.example.bank.domain.clients.exception;

import com.example.bank.domain.clients.entity.Client;

public class ClientNotFoundException extends RuntimeException {

    public ClientNotFoundException(String clientId) {
        super("Client with id %s not found".formatted(clientId));
    }
}
