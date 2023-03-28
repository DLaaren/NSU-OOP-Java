package ru.nsu.fit.vinter.calculator.core.commands;

import ru.nsu.fit.vinter.calculator.core.Command;
import ru.nsu.fit.vinter.calculator.core.ExecutionContext;
import ru.nsu.fit.vinter.calculator.core.Number;
import ru.nsu.fit.vinter.calculator.core.Operand;
import ru.nsu.fit.vinter.calculator.core.Variable;
import ru.nsu.fit.vinter.calculator.core.exceptions.NotEnoughOperandsOnStackException;
import ru.nsu.fit.vinter.calculator.core.exceptions.TooMuchOperandsException;

import java.util.Stack;

public class Push implements Command {
    @Override
    public void apply(ExecutionContext context, String[] args) {
        if (args.length < 2) {
            throw new NotEnoughOperandsOnStackException("There is no operand in the input for pushing");
        }
        if (args.length > 2) {
            throw new TooMuchOperandsException("Excess operands in the input");
        }
        Stack<Operand> stack = context.getStackWithOperands();
        if (Character.isAlphabetic(args[1].charAt(0))) {
            Operand v1 = new Variable(args[1], context);
            stack.push(v1);
        } else {
            Operand v2 = new Number(Double.valueOf(args[1]));
            stack.push(v2);
        }
    }
}
