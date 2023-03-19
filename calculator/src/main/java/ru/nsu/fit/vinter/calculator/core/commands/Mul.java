package ru.nsu.fit.vinter.calculator.core.commands;

import ru.nsu.fit.vinter.calculator.core.Command;
import ru.nsu.fit.vinter.calculator.core.ExecutionContext;
import ru.nsu.fit.vinter.calculator.core.Operand;

import java.util.List;
import java.util.Stack;

public class Mul implements Command {
    @Override
    public void apply(ExecutionContext context, String args[]) {
        Stack<Operand> stack = context.getStackWithOperands();
        var v1 = stack.pop();
        var v2 = stack.pop();
        stack.push(v1*v2);
    }
}
