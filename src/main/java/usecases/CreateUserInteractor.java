package usecases;

import base.Callback;
import domain.model.CreateUserRequestDto;
import domain.repository.Repository;
import controller.model.User;

public class CreateUserInteractor {

    Repository<User, CreateUserRequestDto, Integer> userRepository;

    public CreateUserInteractor(Repository<User, CreateUserRequestDto, Integer> userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(String name, String email, Callback callback) {
        userRepository.create(new CreateUserRequestDto(name, email), callback);
    }
}
