package com.middleservice.domain;

public class RealUserApi implements UserApi{
    @Override
    public void createUser(Long userId, String userName) throws UserAlreadyExistsException {
        // WIP
    }

    @Override
    public void createAccount(Long userId, String accountName) throws AccountAlreadyExistException, UserNotFoundException {
        // WIP
    }
}
