package com.alpha.shopybeebackend.exception.Authentication;

public class EmailPasswordNotMatchingException extends RuntimeException {
    public EmailPasswordNotMatchingException(String message) {
        super(message);
    }
}
