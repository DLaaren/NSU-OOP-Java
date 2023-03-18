package ru.nsu.fit.vinter.calculator.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ExecutionContext {
    private Map<String, Double> mapWithVariables = new HashMap<>();
    private Stack<Double> stackWithOperands = new Stack<>();

    public Stack<Double> getStackWithOperands() {
        return stackWithOperands;
    }

    public Map<String, Double> getMapWithVariables() {
        return mapWithVariables;
    }
}
