package com.example.StealthApp.model.exceptions;

public class JobDoesNotExistException extends RuntimeException{
    public JobDoesNotExistException(String message){
        super(message);
    }
}
