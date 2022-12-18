package com.example.bank.domain.parameters.entity;

import lombok.Getter;

@Getter
public class ParameterType {

    private final String parameterName;
    private final Class<?> parameterType;

    private ParameterType(String parameterName, Class<?> parameterType) {
        this.parameterName = parameterName;
        this.parameterType = parameterType;
    }

    public static final ParameterType POST_TYPES_ALLOWED_ON_CLIENT_TO_CLIENT_TRANSFER =
            new ParameterType("post.types.allowed.client.transfer", String[].class);

}
