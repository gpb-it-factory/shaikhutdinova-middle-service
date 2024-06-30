package com.middleservice.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "У пользователя нет счетов")
public class NoAccountFoundResponseException  extends  Exception{
}
