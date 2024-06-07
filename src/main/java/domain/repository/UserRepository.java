package domain.repository;

import base.Callback;
import base.EventCallback;
import domain.api.UserApi;
import domain.model.CreateUserRequestDto;
import domain.model.UserDto;

//Инкапсуляция обращения к источнику данных о пользователе

public class UserRepository implements Repository<UserDto, CreateUserRequestDto, Integer> {
    private final UserApi userApi;

    public UserRepository(UserApi userApi) {
        this.userApi = userApi;
    }

    @Override
    public void create(CreateUserRequestDto params, Callback callback) {
        userApi.createUser(params.getName(), params.getEmail(), callback);
    }

    @Override
    public void get(Integer id, EventCallback<UserDto> eventCallback) {
        userApi.getUser(id, eventCallback);
    }

    @Override
    public void update(UserDto newModel, Callback callback) {
        callback.onError(new UnsupportedOperationException("not supported"));
    }

    @Override
    public void delete(Integer id, Callback callback) {
        callback.onError(new UnsupportedOperationException("not supported"));
    }
}
