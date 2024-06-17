package com.middleservice.domain;

import org.springframework.stereotype.Component;

//абстракция над источником информации о пользователях

public interface UserApi {
    void createUser(Long userId, String userName) throws UserAlreadyExistsException;
}
