package com.middleservice.domain;

public interface UserApi {
    void createUser(Long userId, String userName) throws UserAlreadyExistsException;

    void createAccount(Long userId, String accountName) throws AccountAlreadyExistException, UserNotFoundException;
}
