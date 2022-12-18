package com.example.bank.domain.statements.entity;

import com.example.bank.domain.clients.entity.Client;

import java.time.LocalDateTime;

public record Balance(Client client, Double currentValue, LocalDateTime lastPosting) {}
