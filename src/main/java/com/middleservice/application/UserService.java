package com.middleservice.application;

import com.middleservice.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(long userId, String userName) throws UserAlreadyExistsException {
        User user = new User(userId, userName);
        userRepository.createUser(user.getUserId(), user.getUserName());
    }

    public void createAccount(long userId) throws AccountAlreadyExistException, UserNotFoundException {
        String accountName = "Акционный";
        userRepository.createAccount(userId, accountName);
    }

    public Account getCurrentBalance(long userId) throws NoAccountFoundException, UserNotFoundException {
        return userRepository.getCurrentBalance(userId);
    }
}
