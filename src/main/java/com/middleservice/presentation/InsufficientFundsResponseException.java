package com.middleservice.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "У пользователя нет счетов")
public class InsufficientFundsResponseException extends RuntimeException {
    public InsufficientFundsResponseException() {
        super("Недостаточно средств для перевода");
    }
}