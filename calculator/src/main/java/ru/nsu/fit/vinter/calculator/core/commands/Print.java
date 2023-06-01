package ru.nsu.fit.vinter.calculator.core.commands;

import ru.nsu.fit.vinter.calculator.core.Command;
import ru.nsu.fit.vinter.calculator.core.ExecutionContext;
import ru.nsu.fit.vinter.calculator.core.Operand;
import ru.nsu.fit.vinter.calculator.core.exceptions.EmptyStackException;
import ru.nsu.fit.vinter.calculator.core.exceptions.TooMuchOperandsException;

import java.util.Stack;


public class Print implements Command {
    @Override
    public void apply(ExecutionContext context, String[] args) {
        if (args.length >= 2) {
            throw new TooMuchOperandsException("This operation takes operands from the stack, not from the input");
        }
        Stack<Operand> stack = context.getStackWithOperands();
        if (stack.empty()) {
            throw new EmptyStackException("Stack is empty, there is nothing to print");
        }
        var v1 = stack.peek();
        System.out.println(v1);
    }
}
