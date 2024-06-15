package com.research.librarymanager_backend.Exceptions;

public class AccessNotFoundException extends RuntimeException {

    public AccessNotFoundException(String message){
        super(message);
    }

}
