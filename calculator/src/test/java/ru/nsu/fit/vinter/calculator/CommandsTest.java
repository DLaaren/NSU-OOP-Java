package ru.nsu.fit.vinter.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.nsu.fit.vinter.calculator.core.Calculator;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandsTest {
    Calculator calculator ;

    @BeforeEach
    void setUp() throws IOException {
        calculator = new Calculator(null);
    }

    @Test
    void addTest() {
        calculator.processCommand("PUSH 4");
        calculator.processCommand("PUSH 9");
        calculator.processCommand("+");
        assertEquals(13, calculator.getLastResult());
    }

    @Test
    void defineTest() {
        calculator.processCommand("DEFINE a 4");
        calculator.processCommand("PUSH a");
        assertEquals(4, calculator.getLastResult());
    }

    @Test
    void divTest() {
        calculator.processCommand("PUSH 5");
        calculator.processCommand("PUSH 100");
        calculator.processCommand("/");
        assertEquals(20, calculator.getLastResult());
    }

    @Test
    void mulTest() {
        calculator.processCommand("PUSH 7");
        calculator.processCommand("PUSH 89");
        calculator.processCommand("*");
        assertEquals(623, calculator.getLastResult());
    }

    @Test
    void popTest() {
        calculator.processCommand("PUSH 7");
        calculator.processCommand("PUSH 89");
        calculator.processCommand("POP");
        assertEquals(7, calculator.getLastResult());
    }

    @Test
    void pushTest() {
        calculator.processCommand("PUSH 100");
        calculator.processCommand("PUSH -100");
        assertEquals(-100, calculator.getLastResult());
    }

    @Test
    void sqrtTest() {
        calculator.processCommand("PUSH 100");
        calculator.processCommand("SQRT");
        assertEquals(10, calculator.getLastResult());
    }

    @Test
    void subTest() {
        calculator.processCommand("PUSH 9");
        calculator.processCommand("PUSH 0");
        calculator.processCommand("-");
        assertEquals(-9, calculator.getLastResult());
    }
}
