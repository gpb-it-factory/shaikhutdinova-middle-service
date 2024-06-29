package com.middleservice.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT, reason = "Счет уже зарегистрирован")
public class AccountAlreadyExistResponseException extends Exception {

}
