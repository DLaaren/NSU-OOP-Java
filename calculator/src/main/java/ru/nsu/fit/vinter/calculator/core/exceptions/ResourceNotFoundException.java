package ru.nsu.fit.vinter.calculator.core.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public  ResourceNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
