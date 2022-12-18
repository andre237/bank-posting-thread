package com.example.bank.domain.statements.ports;

import com.example.bank.domain.statements.entity.StatementPagination;
import com.example.bank.domain.statements.entity.StatementFilter;
import com.example.bank.domain.clients.entity.Client;
import com.example.bank.domain.transfers.entity.Posting;

import java.util.Set;

@FunctionalInterface
public interface FetchRecentPostingsFiltered {

    Set<Posting> execute(Client client, StatementPagination pagination, StatementFilter filter);

}
