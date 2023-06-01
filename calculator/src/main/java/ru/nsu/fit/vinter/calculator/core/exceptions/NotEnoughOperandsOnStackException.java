package ru.nsu.fit.vinter.calculator.core.exceptions;

public class NotEnoughOperandsOnStackException extends CalcException{
    public NotEnoughOperandsOnStackException(String errorMessage) {
        super(errorMessage);
    }
}
