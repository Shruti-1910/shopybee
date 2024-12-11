package com.alpha.shopybeebackend.exception.Authentication;
import com.alpha.shopybeebackend.exception.ApiException;
import com.alpha.shopybeebackend.exception.Authentication.EmailAlreadyPresentException;
import com.alpha.shopybeebackend.exception.Authentication.EmailNotFoundException;
import com.alpha.shopybeebackend.exception.Authentication.EmailPasswordNotMatchingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@ControllerAdvice
public class AuthExceptionHandler {

    @ExceptionHandler(value = {EmailNotFoundException.class})
    public ResponseEntity<Object> handleEmailNotFoundException(EmailNotFoundException exception){
        ApiException apiException = new ApiException(
                exception.getMessage(),
                Timestamp.valueOf(LocalDateTime.now()),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<Object>(apiException,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = {EmailPasswordNotMatchingException.class})
    public ResponseEntity<Object> handleEmailPasswordNotMatchingException(EmailPasswordNotMatchingException exception){
        ApiException apiException = new ApiException(
                exception.getMessage(),
                Timestamp.valueOf(LocalDateTime.now()),
                HttpStatus.BAD_REQUEST
        );

        return new ResponseEntity<Object>(apiException,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {EmailAlreadyPresentException.class})
    public ResponseEntity<Object> handleEmailAlreadyPresentException(EmailAlreadyPresentException exception){
        ApiException apiException = new ApiException(
                exception.getMessage(),
                Timestamp.valueOf(LocalDateTime.now()),
                HttpStatus.BAD_REQUEST
        );

        return new ResponseEntity<Object>(apiException,HttpStatus.NOT_ACCEPTABLE);
    }
}
