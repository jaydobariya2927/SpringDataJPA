package com.example.SpringDataJpaDemo.exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String errorMsg) {
        super(errorMsg);
    }
}
