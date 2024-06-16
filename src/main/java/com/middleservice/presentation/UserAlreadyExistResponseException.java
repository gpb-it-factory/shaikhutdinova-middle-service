package com.middleservice.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Пользователь уже зарегистрирован")
public class UserAlreadyExistResponseException extends Exception {

}
