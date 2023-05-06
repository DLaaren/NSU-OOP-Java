package ru.nsu.fit.vinter.carFactory.core.threadpool;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class ThreadPool implements TaskListener {
    private final Deque<ThreadPoolTask> taskQueue = new ArrayDeque<>();
    private final Set<PooledThread> availableThreads = new HashSet<>();

    public ThreadPool(int threadCounts) {
        //add as many threads as threadCount is
        //and start them all
    }

    public void addTask() {

    }

    public void shutDown() {

    }

    @Override
    public void taskInterrupted(Task task) {
        //log message
    }

    @Override
    public void taskFinished(Task task) {
        //log message
    }

    @Override
    public void taskStarted(Task task) {
        //log message
    }
}
