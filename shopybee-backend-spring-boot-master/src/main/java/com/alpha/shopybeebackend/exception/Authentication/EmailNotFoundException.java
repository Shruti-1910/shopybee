package com.alpha.shopybeebackend.exception.Authentication;

public class EmailNotFoundException extends RuntimeException {
    public EmailNotFoundException(String message) {
        super(message);
    }
}
