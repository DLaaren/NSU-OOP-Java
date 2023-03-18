package ru.nsu.fit.vinter.calculator.core.commands;

import ru.nsu.fit.vinter.calculator.core.Command;
import ru.nsu.fit.vinter.calculator.core.ExecutionContext;

import java.util.Stack;


public class Print implements Command {
    @Override
    public void apply(ExecutionContext context, String args[]) {
        Stack<Double> stack = context.getStackWithOperands();
        var v1 = stack.peek();
        System.out.println(v1);
    }
}
