package com.research.librarymanager_backend.Exceptions;

public class BorrowingNotFoundException extends RuntimeException {

    public BorrowingNotFoundException(String message){
        super(message);
    }

}
