package ru.nsu.fit.vinter.calculator.core.commands;

import ru.nsu.fit.vinter.calculator.core.Command;
import ru.nsu.fit.vinter.calculator.core.ExecutionContext;

import java.util.Map;
import java.util.Stack;

public class Push implements Command {
    @Override
    public void apply(ExecutionContext context, String args[]) {
        Stack<Double> stack = context.getStackWithOperands();
        if (Character.isAlphabetic(args[0].charAt(0))) {
            Map<String, Double> map = context.getMapWithVariables();
            var v1 = map. get(args[0]);
            stack.push(v1);
        } else {
            stack.push(Double.valueOf(args[0]));
        }
    }
}
