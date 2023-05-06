package ru.nsu.fit.vinter.carFactory.core.factory.tasks;

import ru.nsu.fit.vinter.carFactory.core.factory.Car;
import ru.nsu.fit.vinter.carFactory.core.factory.CarFactory;
import ru.nsu.fit.vinter.carFactory.core.factory.Storage;
import ru.nsu.fit.vinter.carFactory.core.factory.spares.Accessories;
import ru.nsu.fit.vinter.carFactory.core.factory.spares.CarBody;
import ru.nsu.fit.vinter.carFactory.core.factory.spares.Motor;
import ru.nsu.fit.vinter.carFactory.core.threadpool.Task;

public class BuildCar implements Task {
    private final CarFactory carFactory;
    private final long workerID;

    private Storage<Motor> motorStorage;
    private Storage<Accessories> accessoriesStorage;
    private Storage<CarBody> carBodyStorage;
    private Storage<Car> carStorage;

    public BuildCar(CarFactory carFactory) {
        this.carFactory = carFactory;
        workerID = carFactory.generateID();
        motorStorage = carFactory.getMotorStorage();
        accessoriesStorage = carFactory.getAccessoriesStorage();
        carBodyStorage = carFactory.getCarBodyStorage();
        carStorage = carFactory.getCarStorage();
    }

    @Override
    public String getTaskName() {
        return "Building car: workerID = " + workerID;
    }

    @Override
    public void performTask() throws InterruptedException {
        while (Thread.currentThread().isInterrupted()) {
            Car currCar = new Car(carFactory.generateID());
            currCar.installCarBody();
            currCar.installMotor();
            currCar.installAccessories();
            carStorage.put(currCar.finishBuildCar());
            carFactory.carBuilt();
        }
    }

    @Override
    public void changeParameters(int newParameters) {}
}
