package ru.nsu.fit.vinter.calculator.core.commands;

import ru.nsu.fit.vinter.calculator.core.Command;
import ru.nsu.fit.vinter.calculator.core.ExecutionContext;

import java.util.List;
import java.util.Stack;

public class Sqrt implements Command {
    @Override
    public void apply(ExecutionContext context, String args[]) {
        Stack<Double> stack = context.getStackWithOperands();
        var v1 = stack.pop();
        v1 = Math.sqrt(v1);
        stack.push(v1);
    }
}
