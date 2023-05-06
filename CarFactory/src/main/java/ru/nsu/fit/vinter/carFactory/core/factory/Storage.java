package ru.nsu.fit.vinter.carFactory.core.factory;

import java.util.ArrayDeque;
import java.util.Deque;

public class Storage<T extends Product> {
    private final String storageName;
    private final int storageCapacity;
    private final Deque<T> items;

    public Storage(String storageName, int storageCapacity) {
        this.storageName = storageName;
        this.storageCapacity = storageCapacity;
        this.items = new ArrayDeque<>();
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

    public T getItem() {
        if (!items.isEmpty()) {
            T item = items.getLast();
            items.removeLast();
        } else {

        }
        return item;
    }
}
