package ru.nsu.fit.vinter.calculator.core.commands;

import ru.nsu.fit.vinter.calculator.core.Command;
import ru.nsu.fit.vinter.calculator.core.ExecutionContext;
import ru.nsu.fit.vinter.calculator.core.Number;
import ru.nsu.fit.vinter.calculator.core.Operand;

import java.util.Stack;

public class Mul implements Command {
    @Override
    public void apply(ExecutionContext context, String[] args) {
        Stack<Operand> stack = context.getStackWithOperands();
        var v1 = stack.pop().getValueOfOperand();
        var v2 = stack.pop().getValueOfOperand();
        Operand result = new Number(v1 * v2);
        stack.push(result);
    }
}
