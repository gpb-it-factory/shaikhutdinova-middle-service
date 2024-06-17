package com.middleservice.presentation;

import com.middleservice.application.UserService;
import com.middleservice.domain.UserAlreadyExistsException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(value = HttpStatus.NO_CONTENT, reason = "Пользовтаель создан")
    @PostMapping("/users")
    public CreateUserResponse createUser(@Valid @RequestBody CreateUserRequest request) throws UserAlreadyExistResponseException {
        try {
            userService.createUser(request.getUserId(), request.getUserName());
        } catch (UserAlreadyExistsException e) {
            throw  new UserAlreadyExistResponseException();
        }

        return new CreateUserResponse(request.getUserId());
    }
}
