package ru.nsu.fit.vinter.calculator.core.commands;

import ru.nsu.fit.vinter.calculator.core.Command;
import ru.nsu.fit.vinter.calculator.core.ExecutionContext;

import java.util.Stack;

public class Add implements Command {
    @Override
    public void apply(ExecutionContext context, String args[]) {
        Stack<Double> stack = context.getStackWithOperands();
        var v1 = stack.pop();
        var v2 = stack.pop();
        stack.push(v1+v2);
    }
}
