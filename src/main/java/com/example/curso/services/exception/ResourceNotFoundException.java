package com.example.curso.services.exception;

public class ResourceNotFoundException extends RuntimeException{


    public ResourceNotFoundException(Object id){
        super("Resource nor found. Id" + id );
    }
}
