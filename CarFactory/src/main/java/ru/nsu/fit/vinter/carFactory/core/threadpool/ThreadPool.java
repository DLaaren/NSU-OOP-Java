package ru.nsu.fit.vinter.carFactory.core.threadpool;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class ThreadPool {
    private final Set<PooledThread> availableThreads = new HashSet<>();
    private final Deque<PooledTask> taskQueue = new ArrayDeque<>();

    public ThreadPool(int threadCount) {
        for (int i = 0; i < threadCount; i++) {
            availableThreads.add(new PooledThread("Thread_" + i, taskQueue));
        }
        for (PooledThread thread : availableThreads) {
            thread.start();
        }
    }

    public void addTask(Task task) {
        synchronized (taskQueue) {
            taskQueue.add(new PooledTask(task));
            taskQueue.notifyAll();
        }
    }

    public void shutDown() {
        for (PooledThread thread : availableThreads) {
            thread.interruptPooledThread();
        }
    }

}
