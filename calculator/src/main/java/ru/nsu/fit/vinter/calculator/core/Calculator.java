package ru.nsu.fit.vinter.calculator.core;

import ru.nsu.fit.vinter.calculator.core.exceptions.CalcException;
import ru.nsu.fit.vinter.calculator.core.exceptions.CanNotCreateClassCommandException;
import ru.nsu.fit.vinter.calculator.core.exceptions.EmptyStackException;

import java.io.BufferedReader;
import java.io.IOException;

public class Calculator {
    private final CommandFactory factory = new CommandFactory();
    private final ExecutionContext calcContext = new ExecutionContext();
    private final BufferedReader reader;

    public Calculator(BufferedReader reader) throws IOException {
        this.reader = reader;
    }

    public void processCommand(String line) {
        String[] splitLine = line.split(" ");
        Command command = factory.getCommand(splitLine[0]);
        command.apply(calcContext, splitLine);
    }

    public void processInput() throws IOException {
        String line = reader.readLine();
        while (!line.equals("stop")) {
            try {
                processCommand(line);
            } catch(CanNotCreateClassCommandException e) {
                System.err.println(e.getMessage());
                System.exit(1);
            } catch(CalcException e) {
                System.err.println(e.getMessage());
            }
            line = reader.readLine();
        }
    }

    public double getLastResult() {
        if (calcContext.isStackEmpty()) {
            throw new EmptyStackException("Can not get result, because context is empty");
        }
        return calcContext.getLastResult();
    }

}
