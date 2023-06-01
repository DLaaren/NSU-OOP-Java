package ru.nsu.fit.vinter.calculator.core;

public interface Command {
    void apply(ExecutionContext context, String[] args);
}
