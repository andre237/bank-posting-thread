package com.example.bank.domain.parameters.ports;

import com.example.bank.domain.parameters.entity.ParameterType;

@FunctionalInterface
public interface GetParameterByName {

    default String execute(ParameterType type) {
        return execute(type, String.class);
    }

    <T> T execute(ParameterType type, Class<T> clazz);

}
