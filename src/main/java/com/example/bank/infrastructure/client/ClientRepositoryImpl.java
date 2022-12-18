package com.example.bank.infrastructure.client;

import com.example.bank.domain.clients.entity.Client;
import com.example.bank.domain.clients.exception.ClientNotFoundException;
import com.example.bank.domain.clients.ports.GetClientById;

import com.example.bank.infrastructure.client.sql.ClientModel;
import com.example.bank.infrastructure.client.sql.JpaClientRepository;

import org.springframework.stereotype.Repository;

@Repository
public class ClientRepositoryImpl implements GetClientById {

    private final JpaClientRepository clientRepositoryDelegate;

    public ClientRepositoryImpl(JpaClientRepository clientRepositoryDelegate) {
        this.clientRepositoryDelegate = clientRepositoryDelegate;
    }

    @Override
    public Client execute(String id) throws ClientNotFoundException {
        return clientRepositoryDelegate.findById(id)
                .map(ClientModel::convertToDomainClient)
                .orElseThrow(() -> new ClientNotFoundException(id));
    }
}
