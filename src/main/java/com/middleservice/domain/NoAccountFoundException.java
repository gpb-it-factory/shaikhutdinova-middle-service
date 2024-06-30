package com.middleservice.domain;

public class NoAccountFoundException extends Exception{
    private  final String message;

    public NoAccountFoundException(String message) {
        super(message);
        this.message = message;
    }
}
