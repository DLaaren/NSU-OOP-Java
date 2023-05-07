package ru.nsu.fit.vinter.carFactory.core.factory.products;

public class Product {
    private final long id;

    public Product(long id) {
        this.id = id;
    }

    public long getID() {
        return id;
    }
}
