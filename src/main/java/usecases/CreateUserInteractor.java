package usecases;

import base.Callback;
import domain.model.CreateUserRequestDto;
import domain.model.UserDto;
import domain.repository.Repository;

public class CreateUserInteractor {

    Repository<UserDto, CreateUserRequestDto, Long> userRepository;

    public CreateUserInteractor(Repository<UserDto, CreateUserRequestDto, Long> userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(Long userId, String userName, Callback callback) {
        userRepository.create(new CreateUserRequestDto(userId, userName), callback);
        callback.onSuccess();
    }
}
