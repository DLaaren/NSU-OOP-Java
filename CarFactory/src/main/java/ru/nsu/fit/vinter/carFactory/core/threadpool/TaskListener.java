package ru.nsu.fit.vinter.carFactory.core.threadpool;

public interface TaskListener {
    void taskInterrupted(Task task);
    void taskFinished(Task task);
    void taskStarted(Task task);
}
