package com.middleservice.presentation;

public class CreateUserResponse {

    private final  long userId;

    public CreateUserResponse(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }
}
