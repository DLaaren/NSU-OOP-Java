package ru.nsu.fit.vinter.carFactory.core.threadpool;

public interface Task {
    String getTaskName();
    void changeParameters(int newParameter);
    void performTask();
}
