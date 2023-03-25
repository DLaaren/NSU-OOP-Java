package ru.nsu.fit.vinter.calculator.core;

public class Number implements Operand {
    private final double value;
    public Number(Double value) {
        this.value = value;
    }
    @Override
    public double getValueOfOperand() {
        return value;
    }

    @Override
    public String toString() {
        return Double.toString(getValueOfOperand());
    }
}
