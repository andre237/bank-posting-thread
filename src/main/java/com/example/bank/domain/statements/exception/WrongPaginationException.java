package com.example.bank.domain.statements.exception;

public class WrongPaginationException extends Exception {

    public WrongPaginationException(String reason) {
        super(reason);
    }
}
