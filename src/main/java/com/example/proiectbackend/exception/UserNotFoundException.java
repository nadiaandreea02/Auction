package com.example.proiectbackend.exception;

import com.example.proiectbackend.model.User;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(Long id){
        super("Could not found the user with id: "+id);
    }
}
