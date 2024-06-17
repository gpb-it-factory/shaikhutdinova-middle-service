package com.middleservice.application;

import com.middleservice.domain.UserRepository;
import com.middleservice.domain.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void createUser(long userId, String userName) throws UserAlreadyExistsException {
        User user = new User(userId,userName);
        userRepository.createUser(user.getUserId(), user.getUserName());
    }
}
