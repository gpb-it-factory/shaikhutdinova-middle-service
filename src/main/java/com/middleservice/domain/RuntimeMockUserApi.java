package com.middleservice.domain;

import java.util.HashMap;
import java.util.Map;

public class RuntimeMockUserApi implements UserApi {
    HashMap<Long, User> users = new HashMap<>();
    HashMap<Long, Account> usersAccounts = new HashMap<>();
    HashMap<String, Long> usernamesToIds = new HashMap<>();

    @Override
    public void createUser(Long userId, String userName) throws UserAlreadyExistsException {
        if (users.containsKey(userId)) {
            throw new UserAlreadyExistsException("Пользователь " + userName + "  уже зарегистрирован");
        }
        users.put(userId, new User(userId, userName));
        usernamesToIds.put(userName, userId);
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
        double initialBalance = 5000.0;
        usersAccounts.put(userId, new Account(userId, accountName, initialBalance));
        for (Map.Entry<Long, Account> entry : usersAccounts.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    @Override
    public Account getCurrentBalance(long userId) throws NoAccountFoundException, UserNotFoundException {
        if (!users.containsKey(userId)) {
            throw new UserNotFoundException("Пользователь с ID " + userId + " не найден");
        }

        Account account = usersAccounts.get(userId);
        if (account == null) {
            throw new NoAccountFoundException("Счет для пользователя с ID " + userId + " не найден");
        }
        return account;
    }

    @Override
    public long getUserIdByUsername(String username) throws UserNotFoundException {
        Long userId = usernamesToIds.get(username);
        if (userId == null) {
            throw new UserNotFoundException("Пользователь с именем " + username + " не найден");
        }
        return userId;
    }

    @Override
    public void updateAccount(Account account) throws UserNotFoundException, NoAccountFoundException {
        if (!users.containsKey(account.getAccountId())) {
            throw new UserNotFoundException("Пользователь не найден");
        }

        if (!usersAccounts.containsKey(account.getAccountId())) {
            throw new NoAccountFoundException("Счет для пользователя не найден");
        }

        usersAccounts.put(account.getAccountId(), account); // Обновление счета
    }
}

