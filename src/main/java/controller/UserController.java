package controller;

import base.Callback;
import domain.api.UserApi;
import domain.api.UserApiCreator;
import domain.model.CreateUserRequestDto;
import domain.model.UserDto;
import domain.repository.Repository;
import domain.repository.UserRepository;
import usecases.CreateUserInteractor;

public class UserController {
    UserApi api = new UserApiCreator(true).create();
    Repository<UserDto, CreateUserRequestDto, Long> repository = new UserRepository(api);
    CreateUserInteractor createUserInteractor = new CreateUserInteractor(repository);


    public void createUser(Long userId, String userName, Callback callback) {
        createUserInteractor.createUser(userId, userName, callback);
    }
}
