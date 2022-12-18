package com.example.bank.domain.statements.ports;

import com.example.bank.domain.clients.entity.Client;
import com.example.bank.domain.statements.entity.StatementPagination;
import com.example.bank.domain.transfers.entity.Posting;
import com.example.bank.domain.statements.exception.WrongPaginationException;

import java.util.Set;

@FunctionalInterface
public interface FetchRecentPostings {

    Set<Posting> execute(Client client, StatementPagination pagination) throws WrongPaginationException;

}
