package ru.nsu.fit.vinter.carFactory.core.threadpool;

import java.util.Deque;
import java.util.concurrent.atomic.AtomicBoolean;

public class PooledThread extends Thread {
    AtomicBoolean shutDownRequired = new AtomicBoolean(false);
    private final Deque<PooledTask> taskQueue;

    public PooledThread(String name, Deque<PooledTask> taskQueue) {
        super(name);
        this.taskQueue = taskQueue;
    }

    public void interruptPooledThread() {
        this.interrupt();
        shutDownRequired.set(true);
    }

    private void performTask(PooledTask task) {
        try {
            task.performTask();
        } catch (InterruptedException e) {
            shutDownRequired.set(true);
        }
    }

    public void run() {
        PooledTask task;
        while (!shutDownRequired.get()) {
            synchronized (taskQueue) {
                if (taskQueue.isEmpty()) {
                    try {
                        taskQueue.wait();
                    } catch (InterruptedException e) {
                        break;
                    }
                    continue;
                } else {
                    task = taskQueue.getFirst();
                    taskQueue.removeFirst();
                }
            }
            performTask(task);
        }
    }
}
