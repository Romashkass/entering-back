package com.example.entering_back.exception;

public class WrongNumberOfArgumentsException extends RuntimeException {
    public WrongNumberOfArgumentsException(String errorMessage) {
        super(errorMessage);
    }
}
