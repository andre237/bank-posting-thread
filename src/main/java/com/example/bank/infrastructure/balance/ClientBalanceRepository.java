package com.example.bank.infrastructure.balance;

import com.example.bank.domain.clients.entity.Client;
import com.example.bank.domain.statements.entity.Balance;
import com.example.bank.domain.statements.ports.GetCurrentBalance;
import com.example.bank.domain.transfers.ports.UpdateClientBalance;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Map;

@Repository
public class ClientBalanceRepository implements UpdateClientBalance, GetCurrentBalance {

    private final RedisTemplate<String, String> redisTemplate;

    public ClientBalanceRepository(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Balance get(Client client) {
        Map<Object, Object> entries = redisTemplate.opsForHash().entries(this.buildClientBalanceKey(client));

        String currentBalance = entries.get("currentBalance").toString();
        String lastUpdate = entries.get("lastUpdate").toString();

        return new Balance(client, Double.parseDouble(currentBalance), LocalDateTime.parse(lastUpdate));
    }

    @Override
    public void update(Double incomingValue, Client client) {
        var opsForHash = redisTemplate.opsForHash();

        String balanceKey = this.buildClientBalanceKey(client);

        opsForHash.increment(balanceKey, "currentBalance", incomingValue);
        opsForHash.put(balanceKey, "lastUpdate", LocalDateTime.now().toString());
    }

    private String buildClientBalanceKey(Client client) {
        return "clientBalance#%s".formatted(client.id());
    }
}
