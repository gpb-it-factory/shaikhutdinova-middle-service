package com.middleservice.domain;

//абстракция над источником информации о пользователях
public interface UserApi {
    void createUser(Long userId, String userName) throws UserAlreadyExistsException;
}
