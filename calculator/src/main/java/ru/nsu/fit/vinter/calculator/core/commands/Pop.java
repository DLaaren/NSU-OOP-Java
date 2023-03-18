package ru.nsu.fit.vinter.calculator.core.commands;

import ru.nsu.fit.vinter.calculator.core.Command;
import ru.nsu.fit.vinter.calculator.core.ExecutionContext;

import java.util.Stack;

public class Pop implements Command {
    @Override
    public void apply(ExecutionContext context, String args[]) {
        Stack<Double> stack = context.getStackWithOperands();
        stack.pop();
    }
}
