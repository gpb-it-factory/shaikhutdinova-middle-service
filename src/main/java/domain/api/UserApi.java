package domain.api;

import base.Callback;
import base.EventCallback;
import domain.model.UserDto;

//абстракция над источником информации о пользователях
public interface UserApi {

    void createUser(Long userId, String userName, Callback callback);

    void getUser(Long userId, EventCallback<UserDto> eventCallback);
}
