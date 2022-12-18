package com.example.bank.domain.statements.entity;

public record StatementPagination(Integer page, Integer limit) {

    public static StatementPagination of(Integer page, Integer limit) {
        return new StatementPagination(page, limit);
    }

}
