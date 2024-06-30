package com.middleservice.presentation;

public class InsufficientFundsResponseException extends RuntimeException {
    public InsufficientFundsResponseException() {
        super("Недостаточно средств для перевода");
    }
}