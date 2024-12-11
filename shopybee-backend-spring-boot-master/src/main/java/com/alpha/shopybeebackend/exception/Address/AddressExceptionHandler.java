package com.alpha.shopybeebackend.exception.Address;

import com.alpha.shopybeebackend.exception.ApiException;
import com.alpha.shopybeebackend.exception.Authentication.EmailNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@ControllerAdvice
public class AddressExceptionHandler {

    @ExceptionHandler(value = {NoAddressesFoundException.class})
    public ResponseEntity<Object> handleNoAddressesFoundException(NoAddressesFoundException exception){
        ApiException apiException = new ApiException(
                exception.getMessage(),
                Timestamp.valueOf(LocalDateTime.now()),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<Object>(apiException,HttpStatus.NOT_FOUND);
    }
}
