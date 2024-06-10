package domain.repository;

import base.Callback;
import base.EventCallback;
import domain.api.UserApi;
import domain.model.CreateUserRequestDto;
import domain.model.UserDto;

//Инкапсуляция обращения к источнику данных о пользователе

public class UserRepository implements Repository<UserDto, CreateUserRequestDto, Long> {
    private final UserApi userApi;

    public UserRepository(UserApi userApi) {
        this.userApi = userApi;
    }

    @Override
    public void create(CreateUserRequestDto params, Callback callback) {
        userApi.createUser(params.getUserId(), params.getUserName(), callback);
    }

    @Override
    public void get(Long userId, EventCallback<UserDto> eventCallback) {
        userApi.getUser(userId, eventCallback);
    }

    @Override
    public void update(UserDto newModel, Callback callback) {
        callback.onError(new UnsupportedOperationException("not supported"));
    }

    @Override
    public void delete(Long id, Callback callback) {
        callback.onError(new UnsupportedOperationException("not supported"));
    }
}
