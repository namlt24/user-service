package com.example.userservice.exception;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String mess){
        super(mess);
    }
}
