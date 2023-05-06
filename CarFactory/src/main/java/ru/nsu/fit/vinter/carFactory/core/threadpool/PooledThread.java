package ru.nsu.fit.vinter.carFactory.core.threadpool;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;

public class PooledThread extends Thread {
    private Queue<Task> taskQueue;

}
