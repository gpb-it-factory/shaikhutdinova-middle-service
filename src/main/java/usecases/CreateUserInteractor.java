package usecases;

import base.Callback;
import domain.model.CreateUserRequestDto;
import domain.model.UserDto;
import domain.repository.Repository;
import controller.model.User;

public class CreateUserInteractor {

    Repository<UserDto, CreateUserRequestDto, Integer> userRepository;

    public CreateUserInteractor(Repository<UserDto, CreateUserRequestDto, Integer> userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String name, String email, Callback callback) {
        userRepository.create(new CreateUserRequestDto(name, email), callback);
    }
}
