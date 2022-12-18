package com.example.bank.application.transferings;

import com.example.bank.application.internal.TransferValidator;
import com.example.bank.domain.clients.entity.Client;
import com.example.bank.domain.clients.ports.GetClientById;
import com.example.bank.domain.transfers.entity.PostType;
import com.example.bank.domain.transfers.entity.Transfer;
import com.example.bank.domain.transfers.ports.MakeTransferBetweenClients;
import com.example.bank.domain.transfers.ports.SaveClientPosting;
import com.example.bank.domain.transfers.ports.UpdateClientBalance;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferExecutionService implements MakeTransferBetweenClients {

    private final GetClientById getClientById;
    private final SaveClientPosting saveClientPosting;
    private final UpdateClientBalance updateClientBalance;
    private final TransferValidator transferValidator;

    public TransferExecutionService(GetClientById getClientById,
                                    SaveClientPosting saveClientPosting,
                                    UpdateClientBalance updateClientBalance,
                                    TransferValidator transferValidator) {
        this.getClientById = getClientById;
        this.saveClientPosting = saveClientPosting;
        this.updateClientBalance = updateClientBalance;
        this.transferValidator = transferValidator;
    }

    @Override
    @Transactional
    public void execute(Transfer transfer, String payerClientId, String receiverClientId) {
        Client clientFrom = getClientById.execute(payerClientId);
        Client clientTo = getClientById.execute(receiverClientId);

        transferValidator.validate(transfer, clientFrom, clientTo); // will throw if not valid

        this.updateBalanceAndSavePosting(-transfer.value(), transfer.type(), clientFrom);
        this.updateBalanceAndSavePosting(transfer.value(), transfer.type(), clientTo);
    }

    private void updateBalanceAndSavePosting(Double balanceUpdate, PostType type, Client client) {
        updateClientBalance.update(balanceUpdate, client);
        saveClientPosting.execute(balanceUpdate, type, client);
    }
}
