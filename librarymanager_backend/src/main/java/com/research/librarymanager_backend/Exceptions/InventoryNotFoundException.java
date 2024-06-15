package com.research.librarymanager_backend.Exceptions;

public class InventoryNotFoundException extends RuntimeException {

    public InventoryNotFoundException(String message){
        super(message);
    }

}
