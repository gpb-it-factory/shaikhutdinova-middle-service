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

    public User createUser(long userId, String userName) throws UserAlreadyExistsException {
        User user = new User(userId, userName);
        userApi.createUser(user.getUserId(), user.getUserName());
        return user;
    }
}
