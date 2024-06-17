package com.middleservice.domain;

import org.springframework.stereotype.Component;


public class UserAlreadyExistsException extends Exception {

    public UserAlreadyExistsException(String message) {
        super(message);
    }
}
