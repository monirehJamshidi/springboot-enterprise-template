package org.j2os.exception;

// =============================
// NotFoundException.java
// =============================
public class NotFoundException extends RuntimeException{
    public NotFoundException(String message){
        super(message);
    }
}