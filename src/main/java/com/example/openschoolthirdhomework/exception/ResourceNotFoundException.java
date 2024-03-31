package com.example.openschoolthirdhomework.exception;

public class ResourceNotFoundException extends RuntimeException{
    final String message;

    public ResourceNotFoundException(String message) {
        this.message = message;
    }
}
