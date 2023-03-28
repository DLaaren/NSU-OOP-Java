package ru.nsu.fit.vinter.calculator.core.exceptions;

public class TooMuchOperandsException extends CalcException{
    public TooMuchOperandsException(String errorMessage) {
        super(errorMessage);
    }
}
