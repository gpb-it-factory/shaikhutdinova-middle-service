package com.middleservice.domain;

import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

// имплементация замоканных данных о пользователях
@Service
public class RuntimeMockUserApi implements UserApi {
    HashMap<Long, User> users = new HashMap<>();

    @Override
    public void createUser(Long userId, String userName) throws UserAlreadyExistsException {
        if (users.containsKey(userId)) {
            throw new UserAlreadyExistsException("Пользователь " + userName + "  уже зарегистрирован");
        }
        users.put(userId, new User(userId, userName));
        for (Map.Entry<Long, User> entry : users.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
