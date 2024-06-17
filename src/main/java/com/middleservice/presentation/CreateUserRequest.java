package com.middleservice.presentation;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public class CreateUserRequest {


    @NotNull(message = "не может быть пустым")
    @Positive(message = "значение должно содержать положительные целые числа")
    private long userId; // Идентификатор пользователя

    @NotNull
    private String userName;

    public CreateUserRequest(long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserId(@NotNull(message = "не может быть пустым") @Positive(message = "значение должно содержать положительные целые числа") long userId) {
        this.userId = userId;
    }

    public void setUserName(@NotNull String userName) {
        this.userName = userName;
    }
}
