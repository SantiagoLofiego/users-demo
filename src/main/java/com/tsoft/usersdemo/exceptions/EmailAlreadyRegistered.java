package com.tsoft.usersdemo.exceptions;

public class EmailAlreadyRegistered extends RuntimeException {
    public EmailAlreadyRegistered(String message){
        super(message);
    }
}
