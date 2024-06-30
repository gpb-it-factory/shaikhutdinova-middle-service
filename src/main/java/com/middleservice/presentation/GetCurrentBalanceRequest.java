package com.middleservice.presentation;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class GetCurrentBalanceRequest {


    @NotNull(message = "не может быть пустым")
    @Positive(message = "значение должно содержать положительные целые числа")
    private long userId;

    public GetCurrentBalanceRequest(long userId) {
        this.userId = userId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

}
