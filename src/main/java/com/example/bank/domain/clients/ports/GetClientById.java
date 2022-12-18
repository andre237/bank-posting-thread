package com.example.bank.domain.clients.ports;

import com.example.bank.domain.clients.entity.Client;
import com.example.bank.domain.clients.exception.ClientNotFoundException;

@FunctionalInterface
public interface GetClientById {

    Client execute(String id) throws ClientNotFoundException;

}
