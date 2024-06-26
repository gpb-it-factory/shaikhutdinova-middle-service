package com.middleservice.application;

import com.middleservice.domain.AccountAlreadyExistException;
import com.middleservice.domain.UserNotFoundException;
import com.middleservice.domain.UserRepository;
import com.middleservice.domain.UserAlreadyExistsException;
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
        Account account = new Account(userId, "Акционный");
        userRepository.createAccount(account.getUserId(), account.getAccountName());
    }
}
