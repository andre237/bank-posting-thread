package com.example.bank.domain.transfers.entity;

import java.time.LocalDateTime;

public record Posting(String id, String description, Double value, PostType type, LocalDateTime timestamp) {}
