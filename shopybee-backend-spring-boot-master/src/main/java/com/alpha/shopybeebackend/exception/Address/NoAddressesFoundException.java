package com.alpha.shopybeebackend.exception.Address;

public class NoAddressesFoundException extends RuntimeException{
    public NoAddressesFoundException(String message) {
        super(message);
    }
}
