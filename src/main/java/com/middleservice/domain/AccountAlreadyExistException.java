package com.middleservice.domain;

public class AccountAlreadyExistException extends Exception {
    public AccountAlreadyExistException(String message) {
        super(message);
    }
}
