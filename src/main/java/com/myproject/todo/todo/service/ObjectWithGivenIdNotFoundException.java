package com.myproject.todo.todo.service;

public class ObjectWithGivenIdNotFoundException extends RuntimeException{
    public ObjectWithGivenIdNotFoundException(Integer id){
        super("Object Todo does not exist with id: "+id);

    }
}
