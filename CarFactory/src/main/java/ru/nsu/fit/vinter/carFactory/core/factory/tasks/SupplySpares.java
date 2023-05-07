package ru.nsu.fit.vinter.carFactory.core.factory.tasks;

import ru.nsu.fit.vinter.carFactory.core.factory.CarFactory;
import ru.nsu.fit.vinter.carFactory.core.factory.products.Product;
import ru.nsu.fit.vinter.carFactory.core.factory.Storage;
import ru.nsu.fit.vinter.carFactory.core.threadpool.Task;

public class SupplySpares<T extends Product> implements Task {
    private int delay;
    private final int price;
    private final CarFactory carFactory;
    private final Storage<T> storage;
    private final Class<T> itemClass;

    public SupplySpares(CarFactory carFactory, Storage<T> storage, Class<T> itemClass, int price, int delay) {
        this.delay = delay;
        this.carFactory = carFactory;
        this.storage = storage;
        this.price = price;
        this.itemClass = itemClass;
    }

    @Override
    public String getTaskName() {
        return "Supllying: spare = " + itemClass.getName();
    }

    @Override
    public void performTask() throws InterruptedException {
        while(!Thread.currentThread().isInterrupted()) {
            //let's imageine that is how he delivers stuff :^)
            Thread.sleep(delay);
        }
    }
}
