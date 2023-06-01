package ru.nsu.fit.vinter.calculator.core.commands;

import ru.nsu.fit.vinter.calculator.core.Command;
import ru.nsu.fit.vinter.calculator.core.ExecutionContext;
import ru.nsu.fit.vinter.calculator.core.exceptions.NotEnoughOperandsOnStackException;
import ru.nsu.fit.vinter.calculator.core.exceptions.TooMuchOperandsException;

import java.util.Map;

public class Define implements Command {
    @Override
    public void apply(ExecutionContext context, String[] args) {
        if (args.length <= 2) {
            throw new NotEnoughOperandsOnStackException("There are less than two operands in the input for definition");
        }
        if (args.length >= 4) {
            throw new TooMuchOperandsException("Excess operands in the input");
        }
        Map<String, Double> map = context.getMapWithVariables();
        map.put(args[1], Double.valueOf(args[2]));
    }
}
