package com.middleservice.domain;

import java.util.HashMap;
import java.util.Map;

public class RuntimeMockUserApi implements UserApi {
    HashMap<Long, User> users = new HashMap<>();
    HashMap<Long, Account> usersAccounts = new HashMap<>();

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

    public void createAccount(Long userId, String accountName) throws AccountAlreadyExistException, UserNotFoundException {
        if (!users.containsKey(userId)) {
            throw new UserNotFoundException("Пользователь с ID " + userId + " не найден");
        }

        if (usersAccounts.containsKey(userId)) {
            throw new AccountAlreadyExistException("Счет для пользователя с ID " + userId + " уже зарегистрирован");
        }

        usersAccounts.put(userId, new Account(userId, accountName));
        for (Map.Entry<Long, Account> entry : usersAccounts.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}