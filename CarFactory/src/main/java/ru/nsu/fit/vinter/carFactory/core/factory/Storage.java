package ru.nsu.fit.vinter.carFactory.core.factory;

import ru.nsu.fit.vinter.carFactory.core.factory.products.Product;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.logging.Logger;

public class Storage<T extends Product> {
    private static final Logger logger = Logger.getLogger(Storage.class.getName());

    private final String storageName;
    private final int storageCapacity;
    private final Deque<T> items;
    private final Object monitor = new Object();

    public Storage(String storageName, int storageCapacity) {
        this.storageName = storageName;
        this.storageCapacity = storageCapacity;
        this.items = new ArrayDeque<>();
        logger.info(storageName + " HAS BEEN CREATED");
    }

    public String getStorageName() {
        return storageName;
    }

    public int getStorageCapacity() {
        return storageCapacity;
    }
    public int getItemCount() {
        return items.size();
    }

    public T takeItem() throws InterruptedException {
        synchronized (monitor) {
            while (true) {
                try {
                    logger.info(storageName + " WITH AMOUNT OF ITEMS = " + items.size());
                    if (!items.isEmpty()) {
                        T item = items.getLast();
                        items.removeLast();
                        monitor.notify();
                        logger.info(storageName + " HAS PASSED PRODUCT");
                        return item;
                    } else {
                        logger.info(storageName + " IS WAITING FOR ITEM");
                        monitor.wait();
                        logger.info(storageName + " HAS GOTTEN ITEM");
                    }
                } catch (InterruptedException e) {
                    logger.info(storageName + " INTERRUPTED");
                    throw e;
                }
            }
        }
    }

    public void put(T newItem) throws InterruptedException {
        synchronized (monitor) {
            if (items.size() >= storageCapacity) {
                monitor.wait();
            }
            items.add(newItem);
            monitor.notify();
        }
    }
}
