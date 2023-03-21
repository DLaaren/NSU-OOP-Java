package ru.nsu.fit.vinter.calculator.core;

import ru.nsu.fit.vinter.calculator.executable.Main;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class CommandFactory {
    private Map<String, Command> commands = new HashMap<>();

    public Command createCommand(ExecutionContext context, String[] args) {
        InputStream in = Main.class.getResourceAsStream("command.properties");
        Properties properties = new Properties();
        properties.load(in);

        String className = ;
        Class<?> commandClass = Class.forName(className);
        Command command = commandClass.forName(className).newInstance();

        return command;
    }

}
