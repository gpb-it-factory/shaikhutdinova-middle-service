package domain.api;

import base.Callback;
import base.EventCallback;
import domain.model.UserDto;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// имплементация замоканных данных о пользователях
public class RuntimeMockUserApi implements UserApi {

    HashMap<Long, UserDto> users = new HashMap<>();

    @Override
    public void createUser(Long userId, String userName, Callback callback) {

        if (users.containsKey(userId)) {
            callback.onError(new IllegalStateException("Пользователь с таким идентификатором уже существует " + userId));
        } else {
            users.put(userId, new UserDto(userId,userName));
        }

        for (Map.Entry<Long, UserDto> entry : users.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    @Override
    public void getUser(Long userId, EventCallback<UserDto> eventCallback) {
        if (users.containsKey(userId)) {
            eventCallback.onNewEvent(users.get(userId));
        } else {
            eventCallback.onError(new IllegalStateException("Пользователь с данным идентификатором  отсутствует"));
        }
    }
}
