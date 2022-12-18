package com.example.bank.domain.transfers.exception;

import com.example.bank.domain.transfers.entity.PostType;

public class TransferTypeNotAllowed extends RuntimeException {

    public TransferTypeNotAllowed(PostType type) {
        super("Not allowed to use %s type on current transaction".formatted(type.name()));
    }
}
