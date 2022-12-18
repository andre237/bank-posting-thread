package com.example.bank.infrastructure.client.sql;

import com.example.bank.domain.clients.entity.Client;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table @Entity(name = "client")
public class ClientModel {

    @Id
    private String cuid;
    private String email;
    private String fullName;
    private Date dateOfBirth;

    public Client convertToDomainClient() {
        return new Client(cuid, email, fullName, dateOfBirth);
    }

}
