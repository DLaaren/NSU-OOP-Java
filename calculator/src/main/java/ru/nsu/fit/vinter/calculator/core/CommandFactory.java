package ru.nsu.fit.vinter.calculator.core;

import ru.nsu.fit.vinter.calculator.core.exceptions.CanNotCreateClassCommandException;
import ru.nsu.fit.vinter.calculator.core.exceptions.NoSuchCommandException;
import ru.nsu.fit.vinter.calculator.core.exceptions.ResourceNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CommandFactory {
    private final Map<String, Command> commands = new HashMap<>();

    public CommandFactory() throws IOException, ResourceNotFoundException {
        InputStream inputStream = CommandFactory.class.getResourceAsStream("/commands.txt");

        if (Objects.isNull(inputStream)) {
            throw new ResourceNotFoundException("File \"commands.txt\" can not be found");
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        while (reader.ready()) {
            String line = reader.readLine();
            String[] splitLine = line.split(" ");
            Command command = createCommand(splitLine[1]);
            commands.putIfAbsent(splitLine[0], command);
        }
    }

    private static Command createCommand(String className) {
        Class<?> commandClass;
        try {
            commandClass = Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new CanNotCreateClassCommandException("Check the file with commands");
        }
        try {
            return (Command) commandClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            throw new CanNotCreateClassCommandException("Check constructors of commands");
        }
    }

    public Command getCommand(String className) {
        if (commands.get(className) == null) {
            throw new NoSuchCommandException("There is no such command");
        }
        return commands.get(className);
    }

}
