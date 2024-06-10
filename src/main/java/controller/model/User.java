package controller.model;

import domain.model.UserDto;

import java.util.Objects;

public class User {
    private final int userId; // Идентификатор пользователя
    private final String userName; // Имя пользователя
    private final String email; // Электронная почта пользователя
    private final String password; // Пароль пользователя

    public User(int userId, String userName, String email, String password) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDto userDto)) return false;
        return getUserId() == userDto.getUserId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId());
    }
}