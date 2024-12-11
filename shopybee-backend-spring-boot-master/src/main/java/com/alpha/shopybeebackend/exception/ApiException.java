package com.alpha.shopybeebackend.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

@Data
public class ApiException {
    private final String error;
    private final Timestamp timestamp;
    private final HttpStatus httpStatus;

    public ApiException(String error, Timestamp timestamp, HttpStatus httpStatus) {
        this.error = error;
        this.timestamp = timestamp;
        this.httpStatus = httpStatus;
    }
}
