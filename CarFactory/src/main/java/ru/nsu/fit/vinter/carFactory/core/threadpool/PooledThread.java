package ru.nsu.fit.vinter.carFactory.core.threadpool;

import java.util.Deque;
import java.util.concurrent.atomic.AtomicBoolean;

public class PooledThread extends Thread {
    AtomicBoolean shutDownRequired = new AtomicBoolean(false);
    private final Deque<Task> taskQueue;

    public PooledThread(String name, Deque<Task> taskQueue) {
        super(name);
        this.taskQueue = taskQueue;
    }

    public void interruptPooledThread() {
        this.interrupt();
        shutDownRequired.set(true);
    }

    private void performTask() {

    }

}
