package com.example.bank.domain.transfers.ports;

import com.example.bank.domain.transfers.entity.Transfer;

@FunctionalInterface
public interface MakeTransferBetweenClients {

    void execute(Transfer transfer, String payerClientId, String receiverClientId);

}
