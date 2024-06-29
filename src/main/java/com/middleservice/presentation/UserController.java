package com.middleservice.presentation;

import com.middleservice.application.UserService;
import com.middleservice.domain.AccountAlreadyExistException;
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
    public UserController (UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping("/v2/users")
    public CreateUserResponse createUser(@Valid @RequestBody CreateUserRequest request) throws UserAlreadyExistResponseException {
        try {
            userService.createUser(request.getUserId(), request.getUserName());
        } catch (UserAlreadyExistsException e) {
            throw new UserAlreadyExistResponseException();
        }

        return new CreateUserResponse(request.getUserId());
    }

    @ResponseStatus(value = HttpStatus.CREATED)
    @PostMapping(path ="/v2/users/{id}/accounts")
    public CreateAccountResponse createAccount(@PathVariable long id) throws AccountAlreadyExistResponseException, UserNotFoundResponseException {
        try {
            userService.createAccount(id);
        } catch (AccountAlreadyExistException e) {
            throw new AccountAlreadyExistResponseException();
        } catch (UserNotFoundException e) {
            throw new UserNotFoundResponseException();
        }
        return new CreateAccountResponse("Акционный счет создан успешно");
    }
}
