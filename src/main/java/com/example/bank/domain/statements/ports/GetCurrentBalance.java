package com.example.bank.domain.statements.ports;

import com.example.bank.domain.statements.entity.Balance;
import com.example.bank.domain.clients.entity.Client;

@FunctionalInterface
public interface GetCurrentBalance {

    Balance get(Client client);

}
