package org.senai.bookstore.Service.exceptions;

public class ObjectNotFoundException extends RuntimeException{
    
    private static final long serialVersionUID=1L;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    
}
