package com.example.bank.infrastructure.statement;

import com.example.bank.domain.clients.entity.Client;
import com.example.bank.domain.statements.entity.StatementFilter;
import com.example.bank.domain.statements.entity.StatementPagination;
import com.example.bank.domain.statements.ports.FetchRecentPostingsFiltered;
import com.example.bank.domain.transfers.entity.PostType;
import com.example.bank.domain.transfers.entity.Posting;
import com.example.bank.domain.transfers.ports.SaveClientPosting;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class PostingStatementRepositoryImpl implements SaveClientPosting, FetchRecentPostingsFiltered {

    @Override
    public Set<Posting> execute(Client client, StatementPagination pagination, StatementFilter filter) {
        return null;
    }

    @Override
    public void execute(Double value, PostType type, Client client) {

    }
}
