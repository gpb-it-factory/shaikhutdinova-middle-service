package com.middleservice.domain;

import com.middleservice.base.Creator;

//Фактори для UserApi
public class UserApiCreator implements Creator<UserApi> {

    private final boolean useMock;

    @Override
    public UserApi create() {
        if (useMock) {
            return new RuntimeMockUserApi();
        } else {
            throw new UnsupportedOperationException("Поддерживается имплементация с использованием mock-данных");
        }
    }

    public UserApiCreator(boolean useMock) {
        this.useMock = useMock;
    }
}
