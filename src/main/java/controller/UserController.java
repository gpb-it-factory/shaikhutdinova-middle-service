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
    Repository<UserDto, CreateUserRequestDto, Integer> repository = new UserRepository(api);
    CreateUserInteractor createUserInteractor = new CreateUserInteractor(repository);


    public void createUser(String name, String email, Callback callback) {

        createUserInteractor.createUser(name, email, callback);
    }
}
