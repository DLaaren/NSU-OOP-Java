package ru.nsu.fit.vinter.calculator.executable;

import ru.nsu.fit.vinter.calculator.core.Calculator;
import ru.nsu.fit.vinter.calculator.core.exceptions.TooMuchArgsForInputException;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, TooMuchArgsForInputException {
        InputStream inputStream;
        BufferedReader reader;

        if (args.length == 0) { //from terminal
            inputStream = System.in;
            reader = new BufferedReader(new InputStreamReader(inputStream));
        } else{ //from file
            inputStream = new FileInputStream(args[0]);
            reader = new BufferedReader(new InputStreamReader(inputStream));
        }

        Calculator calculator = new Calculator(reader);
        calculator.processInput();
    }
}