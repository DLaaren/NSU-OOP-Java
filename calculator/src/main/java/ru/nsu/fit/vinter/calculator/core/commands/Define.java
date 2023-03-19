package ru.nsu.fit.vinter.calculator.core.commands;

import ru.nsu.fit.vinter.calculator.core.Command;
import ru.nsu.fit.vinter.calculator.core.ExecutionContext;

import java.util.Map;

public class Define implements Command {
    @Override
    public void apply(ExecutionContext context, String args[]) {
        Map<String, Double> map = context.getMapWithVariables();
        map.put(args[1], Double.valueOf(args[2]));
    }
}
