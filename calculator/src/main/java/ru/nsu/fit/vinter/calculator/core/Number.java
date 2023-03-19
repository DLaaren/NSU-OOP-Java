package ru.nsu.fit.vinter.calculator.core;

public class Number implements Operand {
    private double value;
    public Number(Double value) {
        this.value = value;
    }
    @Override
    public double getValueOfOperand() {
        return value;
    }
}
