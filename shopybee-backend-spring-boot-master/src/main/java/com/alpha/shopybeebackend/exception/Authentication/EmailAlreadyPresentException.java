package com.alpha.shopybeebackend.exception.Authentication;

import java.nio.file.FileAlreadyExistsException;

public class EmailAlreadyPresentException extends RuntimeException {

    public EmailAlreadyPresentException(String message) {
        super(message);
    }
}
