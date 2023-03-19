package ru.nsu.fit.vinter.calculator.core.commands;

import ru.nsu.fit.vinter.calculator.core.Command;
import ru.nsu.fit.vinter.calculator.core.ExecutionContext;
import ru.nsu.fit.vinter.calculator.core.Number;
import ru.nsu.fit.vinter.calculator.core.Operand;

import java.util.List;
import java.util.Stack;

public class Div implements Command {
    @Override
    public void apply(ExecutionContext context, String args[]) {
        Stack<Operand> stack = context.getStackWithOperands();
        var v1 = stack.pop().getValueOfOperand();
        var v2 = stack.pop().getValueOfOperand();
        var resDiv = v1 / v2;
        Operand result = new Number(resDiv);
        stack.push(result);
    }
}
