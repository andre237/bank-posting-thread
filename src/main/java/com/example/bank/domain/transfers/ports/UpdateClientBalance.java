package com.example.bank.domain.transfers.ports;

import com.example.bank.domain.clients.entity.Client;

@FunctionalInterface
public interface UpdateClientBalance {

    void update(Double incomingValue, Client client);

}
