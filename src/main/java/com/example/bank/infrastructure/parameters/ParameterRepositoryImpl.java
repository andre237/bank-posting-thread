package com.example.bank.infrastructure.parameters;

import com.example.bank.domain.parameters.entity.ParameterType;
import com.example.bank.domain.parameters.ports.GetParameterByName;

import org.springframework.stereotype.Repository;

@Repository
public class ParameterRepositoryImpl implements GetParameterByName {

    @Override
    public <T> T execute(ParameterType type, Class<T> clazz) {
        return null;
    }
}
