package com.middleservice.presentation;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateAccountResponse {

    private final String message;

    public CreateAccountResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
