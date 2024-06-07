package domain.api;

import base.Callback;
import base.EventCallback;
import domain.model.UserDto;

//абстракция над источником информации о пользователях
public interface UserApi {

    void createUser(String name, String email, Callback callback);

    void getUser(int userId, EventCallback<UserDto> eventCallback);
}
