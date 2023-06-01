package ru.nsu.fit.vinter.carFactory.core.threadpool;

public class PooledTask implements Task {
    private  final Task task;

    public PooledTask(Task task) {
        this.task = task;
    }

    @Override
    public void performTask() throws InterruptedException {
        task.performTask();
    }
}
