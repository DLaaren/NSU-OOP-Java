package ru.nsu.fit.vinter.calculator.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExecutionContext {
    private final Map<String, Double> mapWithVariables = new HashMap<>();
    private final Stack<Operand> stackWithOperands = new Stack<>();

    public Stack<Operand> getStackWithOperands() {
        return stackWithOperands;
    }

    public Map<String, Double> getMapWithVariables() {
        return mapWithVariables;
    }

    public double getLastResult() {
        return stackWithOperands.peek().getValueOfOperand();
    }
    public boolean isStackEmpty() {
        return stackWithOperands.isEmpty();
    }
}
