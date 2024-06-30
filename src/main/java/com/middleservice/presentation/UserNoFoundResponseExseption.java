package com.middleservice.presentation;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "Пользователь не найден")
public class UserNoFoundResponseExseption {
}
