package com.middleservice.presentation;

public class CreateAccountResponse {
    private final String message;

    public CreateAccountResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
