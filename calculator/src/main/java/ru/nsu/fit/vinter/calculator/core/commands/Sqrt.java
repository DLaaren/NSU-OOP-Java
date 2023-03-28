package ru.nsu.fit.vinter.calculator.core.commands;

import ru.nsu.fit.vinter.calculator.core.Command;
import ru.nsu.fit.vinter.calculator.core.ExecutionContext;
import ru.nsu.fit.vinter.calculator.core.Number;
import ru.nsu.fit.vinter.calculator.core.Operand;
import ru.nsu.fit.vinter.calculator.core.exceptions.NotEnoughOperandsOnStackException;
import ru.nsu.fit.vinter.calculator.core.exceptions.TooMuchOperandsException;

import java.util.Stack;

public class Sqrt implements Command {
    @Override
    public void apply(ExecutionContext context, String[] args) {
        if (args.length > 1) {
            throw new TooMuchOperandsException("This operation takes operands from the stack, not from the input");
        }
        Stack<Operand> stack = context.getStackWithOperands();
        if (stack.size() < 2) {
            throw new NotEnoughOperandsOnStackException("There are less than two operands on the stack for sqrt");
        }
        var v1 = stack.pop().getValueOfOperand();
        v1 = Math.sqrt(v1);
        Operand result = new Number(v1);
        stack.push(result);
    }
}
