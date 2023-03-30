package ru.nsu.fit.vinter.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.nsu.fit.vinter.calculator.core.Calculator;
import ru.nsu.fit.vinter.calculator.core.exceptions.EmptyStackException;
import ru.nsu.fit.vinter.calculator.core.exceptions.NoSuchCommandException;
import ru.nsu.fit.vinter.calculator.core.exceptions.NotEnoughOperandsOnStackException;
import ru.nsu.fit.vinter.calculator.core.exceptions.TooMuchOperandsException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertThrows;


public class ExceptionsTest {
    Calculator calculator ;

    @BeforeEach
    void setUp() throws IOException {
        calculator = new Calculator(null);
    }

    @Test
    void tooMuchOperandsExceptionTest() {
        assertThrows(TooMuchOperandsException.class, () -> {
            calculator.processCommand("PUSH 4");
            calculator.processCommand("PUSH 9");
            calculator.processCommand("+ 5 9");
        });
    }

    @Test
    void notEnoughOperandsOnStackExceptionTest() {
        assertThrows(NotEnoughOperandsOnStackException.class, () -> {
            calculator.processCommand("PUSH 4");
            calculator.processCommand("+");
        });
    }

    @Test
    void noSuchCommandExceptionTest() {
        assertThrows(NoSuchCommandException.class, () -> {
            calculator.processCommand("PUSH 4");
            calculator.processCommand("take");
        });
    }

    @Test
    void emptyStackExceptionTest() {
        assertThrows(EmptyStackException.class, () -> {
            calculator.processCommand("PRINT");
        });
    }
}
