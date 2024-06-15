package com.research.librarymanager_backend.Exceptions;

public class BookCopyNotFoundException extends RuntimeException {

    public BookCopyNotFoundException(String message){
        super(message);
    }

}
