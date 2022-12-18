package com.example.bank.domain.transfers.ports;

import com.example.bank.domain.clients.entity.Client;
import com.example.bank.domain.transfers.entity.PostType;

@FunctionalInterface
public interface SaveClientPosting {

    void execute(Double value, PostType type, Client client);

}
