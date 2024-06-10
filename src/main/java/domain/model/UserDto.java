package domain.model;

import java.util.Objects;

// Класс, представляющий пользователя
public class UserDto {
    private Long userId; // Идентификатор пользователя
    private String userName; // Имя пользователя


    public UserDto(Long userId, String userName) {
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
        UserDto userDto = (UserDto) o;
        return Objects.equals(userId, userDto.userId) && Objects.equals(userName, userDto.userName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userName);
    }
}
