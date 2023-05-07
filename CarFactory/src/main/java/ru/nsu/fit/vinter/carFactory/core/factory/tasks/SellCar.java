package ru.nsu.fit.vinter.carFactory.core.factory.tasks;

import ru.nsu.fit.vinter.carFactory.core.factory.products.Car;
import ru.nsu.fit.vinter.carFactory.core.factory.CarFactory;
import ru.nsu.fit.vinter.carFactory.core.factory.Storage;
import ru.nsu.fit.vinter.carFactory.core.threadpool.Task;

public class SellCar implements Task {
    private long dealerID;
    private int delay;
    private final int carPrice;
    private final CarFactory carFactory;
    private Storage<Car> carStorage;

    public SellCar(CarFactory carFactory, int carPrice, int delay) {
        this.delay = delay;
        this.carPrice = carPrice;
        this.carFactory = carFactory;
        this.carStorage = carFactory.getCarStorage();
        dealerID = carFactory.generateID();
    }


    @Override
    public String getTaskName() {
        return "Selling car: dealerID = " + dealerID;
    }

    @Override
    public void performTask() throws InterruptedException {
        while (!Thread.currentThread().isInterrupted()) {
            //let's imagine that is how he sells car
            Thread.sleep(delay);
            carStorage.takeItem();
            carFactory.carSold(carPrice);
        }
    }
}
