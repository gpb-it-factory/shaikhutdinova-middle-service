package domain.model;

import java.util.Objects;

// Класс, представляющий пользователя
public class UserDto {
    private int userId; // Идентификатор пользователя
    private String userName; // Имя пользователя
    private String email; // Электронная почта пользователя
    private String password; // Пароль пользователя

    public UserDto(int userId, String userName, String email, String password) {
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
        if (!(o instanceof UserDto)) return false;
        UserDto userDto = (UserDto) o;
        return getUserId() == userDto.getUserId() &&
                Objects.equals(getUserName(), userDto.getUserName()) &&
                Objects.equals(getEmail(), userDto.getEmail()) &&
                Objects.equals(getPassword(), userDto.getPassword());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getUserName(), getEmail(), getPassword());
    }

}
