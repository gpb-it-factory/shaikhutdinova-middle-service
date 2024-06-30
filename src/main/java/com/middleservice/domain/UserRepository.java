package com.middleservice.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final UserApi userApi;

    @Autowired
    public UserRepository(UserApi userApi) {
        this.userApi = userApi;
    }

    public void createUser(long userId, String userName) throws UserAlreadyExistsException {
        User user = new User(userId, userName);
        userApi.createUser(user.getUserId(), user.getUserName());
    }

    public void createAccount(long userId, String accountName) throws AccountAlreadyExistException, UserNotFoundException {
        userApi.createAccount(userId, accountName);
    }

    public Account getCurrentBalance(long userId) throws NoAccountFoundException, UserNotFoundException {
        return userApi.getCurrentBalance(userId);
    }
    public long getUserIdByUsername(String username) throws UserNotFoundException {
        return userApi.getUserIdByUsername(username);
    }

    void updateAccount(Account account) throws UserNotFoundException, NoAccountFoundException{
        return;
    }
}
