package ru.nsu.fit.vinter.carFactory.core.factory.tasks;

import ru.nsu.fit.vinter.carFactory.core.factory.CarFactory;
import ru.nsu.fit.vinter.carFactory.core.factory.products.Product;
import ru.nsu.fit.vinter.carFactory.core.factory.Storage;
import ru.nsu.fit.vinter.carFactory.core.threadpool.Task;

import java.lang.reflect.InvocationTargetException;
import java.util.logging.Logger;

public class SupplySpares<T extends Product> implements Task {
    Logger log = Logger.getLogger(CarFactory.class.getName());

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
    public void performTask() {
        while(!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(delay);
                T item = itemClass.getDeclaredConstructor(long.class).newInstance(carFactory.generateID());
                storage.put(item);
                carFactory.sparesBought(price);
                log.info("SPARE HAS BEEN BOUGHT\n");
            } catch (InterruptedException e) {
                break;
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                     InvocationTargetException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
