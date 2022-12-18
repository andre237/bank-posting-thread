package com.example.bank.domain.transfers.exception;

import com.example.bank.domain.clients.entity.Client;

public class NoBalanceAvailableException extends RuntimeException {

    public NoBalanceAvailableException(Client payerClient) {
        super("Account %s has not enough balance to fulfill the transfer".formatted(payerClient.id()));
    }

}
