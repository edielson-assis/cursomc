package com.edielsonassis.cursomc.services.excepitions;

public class ObjectNotFoundException extends RuntimeException {
    
    public ObjectNotFoundException(String msg) {
        super(msg);
    }

    public ObjectNotFoundException(String msg, Throwable causa) {
        super(msg, causa);
    }
}