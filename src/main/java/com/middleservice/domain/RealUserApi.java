package com.middleservice.domain;

public class RealUserApi implements UserApi{
    @Override
    public void createUser(Long userId, String userName) throws UserAlreadyExistsException {
        throw new IllegalStateException("Not supported");
    }

    @Override
    public void createAccount(Long userId, String accountName) throws AccountAlreadyExistException, UserNotFoundException {
        throw new IllegalStateException("Not supported");
    }

    @Override
    public Account getCurrentBalance(long userId) throws NoAccountFoundException, UserNotFoundException {
        throw new IllegalStateException("Not supported");
    }
}
