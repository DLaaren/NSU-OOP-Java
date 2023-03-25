package ru.nsu.fit.vinter.calculator.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Calculator {
    private final CommandFactory factory = new CommandFactory();
    private final ExecutionContext calcContext = new ExecutionContext();
    private BufferedReader reader;

    public Calculator(BufferedReader reader) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        this.reader = reader;
    }

    public void processCommand(String line) {
        String[] splitLine = line.split(" ");
        Command command = factory.getCommand(splitLine[0]);
        command.apply(calcContext, splitLine);
    }

    public void processInput() throws IOException {
        String line = reader.readLine();
        while (line != "stop this shit") {
            processCommand(line);
            line = reader.readLine();
        }
    }

}
