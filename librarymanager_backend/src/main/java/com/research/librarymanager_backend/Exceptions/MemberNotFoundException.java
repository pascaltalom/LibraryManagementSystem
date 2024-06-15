package com.research.librarymanager_backend.Exceptions;

public class MemberNotFoundException extends RuntimeException {

    public MemberNotFoundException(String message){
        super(message);
    }

}
