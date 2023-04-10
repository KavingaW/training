package com.example.springproject.exceptions;

public class NotFoundException extends RuntimeException{

    public NotFoundException(final String message){
        super(message);
    }

}
