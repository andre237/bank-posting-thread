package com.example.bank.domain.clients.entity;

import java.util.Date;

public record Client(String id, String email, String fullName, Date dateOfBirth) {

}
