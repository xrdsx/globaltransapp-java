package com.globaltransapp.globaltransappbackend.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(Long id){
        super("Nie znleziono użtykownik a z tym id:" + id);
    }
}
