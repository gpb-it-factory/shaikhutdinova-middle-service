package com.middleservice.presentation;

import org.springframework.stereotype.Component;


public class CreateUserResponse {

    private final  long userId;

    public CreateUserResponse(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }
}
