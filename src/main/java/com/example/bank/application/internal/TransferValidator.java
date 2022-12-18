package com.example.bank.application.internal;

import com.example.bank.domain.clients.entity.Client;
import com.example.bank.domain.parameters.ports.GetParameterByName;
import com.example.bank.domain.statements.ports.GetCurrentBalance;
import com.example.bank.domain.transfers.entity.Transfer;
import com.example.bank.domain.transfers.exception.NoBalanceAvailableException;
import com.example.bank.domain.transfers.exception.TransferTypeNotAllowed;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

import static com.example.bank.domain.parameters.entity.ParameterType.POST_TYPES_ALLOWED_ON_CLIENT_TO_CLIENT_TRANSFER;

@Component
public class TransferValidator {

    private final GetCurrentBalance getCurrentBalance;
    private final GetParameterByName getParameterByName;

    public TransferValidator(GetCurrentBalance getCurrentBalance,
                             GetParameterByName getParameterByName) {
        this.getCurrentBalance = getCurrentBalance;
        this.getParameterByName = getParameterByName;
    }

    /**
     * Validates if the transfer type is allowed and if the payerClient has enough balance
     */
    @SuppressWarnings("unused") // receiverClient currently unused, but might in future
    public void validate(Transfer transfer, Client payerClient, Client receiverClient) throws RuntimeException {
        if (!this.isTransferTypeAllowed(transfer))
            throw new TransferTypeNotAllowed(transfer.type());

        if (!this.hasEnoughBalance(payerClient, transfer)) {
            throw new NoBalanceAvailableException(payerClient);
        }
    }

    private boolean isTransferTypeAllowed(Transfer transfer) {
        String[] allowedTypes = getParameterByName.execute(POST_TYPES_ALLOWED_ON_CLIENT_TO_CLIENT_TRANSFER, String[].class);
        return allowedTypes.length == 0 || Arrays.stream(allowedTypes).anyMatch(type -> type.equals(transfer.type().name()));
    }

    private boolean hasEnoughBalance(Client client, Transfer transfer) {
        return Optional.ofNullable(getCurrentBalance.get(client))
                .map(balance -> balance.currentValue().compareTo(transfer.value()) > 0)
                .orElse(false);
    }

}
