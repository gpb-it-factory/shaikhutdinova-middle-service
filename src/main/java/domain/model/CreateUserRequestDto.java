package domain.model;

import java.util.Objects;

public class CreateUserRequestDto {
    final Long userId;
    final String userName;

    public CreateUserRequestDto(Long userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }
}




