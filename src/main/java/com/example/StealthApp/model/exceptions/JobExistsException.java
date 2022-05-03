package com.example.StealthApp.model.exceptions;

public class JobExistsException extends RuntimeException {
    public JobExistsException(String message){
        super(message);
    }
}
