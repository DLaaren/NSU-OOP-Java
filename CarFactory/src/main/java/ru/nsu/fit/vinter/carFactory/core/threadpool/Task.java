package ru.nsu.fit.vinter.carFactory.core.threadpool;

public interface Task {
    void performTask() throws InterruptedException;
}
