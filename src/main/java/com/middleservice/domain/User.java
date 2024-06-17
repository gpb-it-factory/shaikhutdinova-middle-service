package com.middleservice.domain;

import org.springframework.stereotype.Component;

import java.util.Objects;

public class User {
    private final Long userId; // Идентификатор пользователя
    private final String userName; // Имя пользователя


    public User(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;

    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User userDto = (User) o;
        return Objects.equals(userId, userDto.userId) && Objects.equals(userName, userDto.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName);
    }
}
