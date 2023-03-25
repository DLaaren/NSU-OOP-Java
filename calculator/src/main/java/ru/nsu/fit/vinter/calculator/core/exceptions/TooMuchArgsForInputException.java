package ru.nsu.fit.vinter.calculator.core.exceptions;

public class TooMuchArgsForInputException extends Exception {
    public TooMuchArgsForInputException(String errorMessage) {
        super(errorMessage);
    }
}
