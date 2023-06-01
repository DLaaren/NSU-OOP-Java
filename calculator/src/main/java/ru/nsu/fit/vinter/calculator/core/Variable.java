package ru.nsu.fit.vinter.calculator.core;

import java.util.Map;

public class Variable implements Operand {
    private final String variable;
    private final ExecutionContext context;

    public Variable(String variable, ExecutionContext context) {
        this.variable = variable;
        this.context = context;
    }

    @Override
    public double getValueOfOperand() {
        Map<String, Double> map = context.getMapWithVariables();
        return map.get(variable);
    }
}
