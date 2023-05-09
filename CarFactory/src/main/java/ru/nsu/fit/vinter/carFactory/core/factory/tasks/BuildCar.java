package ru.nsu.fit.vinter.carFactory.core.factory.tasks;

import ru.nsu.fit.vinter.carFactory.core.factory.products.Car;
import ru.nsu.fit.vinter.carFactory.core.factory.CarFactory;
import ru.nsu.fit.vinter.carFactory.core.factory.Storage;
import ru.nsu.fit.vinter.carFactory.core.factory.products.spares.Accessories;
import ru.nsu.fit.vinter.carFactory.core.factory.products.spares.CarBody;
import ru.nsu.fit.vinter.carFactory.core.factory.products.spares.Motor;
import ru.nsu.fit.vinter.carFactory.core.threadpool.Task;

import java.util.logging.Logger;

import static java.lang.Thread.sleep;

public class BuildCar implements Task {
    private Logger logger = Logger.getLogger(BuildCar.class.toString());

    private final CarFactory carFactory;
    private final long workerID;
    private int delay;
    private int salary;

    private Storage<Motor> motorStorage;
    private Storage<Accessories> accessoriesStorage;
    private Storage<CarBody> carBodyStorage;
    private Storage<Car> carStorage;

    public BuildCar(CarFactory carFactory, int salary, int delay) {
        this.carFactory = carFactory;
        workerID = carFactory.generateID();
        motorStorage = carFactory.getMotorStorage();
        accessoriesStorage = carFactory.getAccessoriesStorage();
        carBodyStorage = carFactory.getCarBodyStorage();
        carStorage = carFactory.getCarStorage();
        this.salary = salary;
        this.delay = delay;
    }

    @Override
    public void performTask() throws InterruptedException {
        while (Thread.currentThread().isInterrupted()) {
            Car currCar = new Car(carFactory.generateID());
            currCar.installCarBody(carBodyStorage.takeItem());
            currCar.installMotor(motorStorage.takeItem());
            currCar.installAccessories(accessoriesStorage.takeItem());
            sleep(delay);
            carStorage.put(currCar.finishBuildCar());
            carFactory.carBuilt(salary);
            logger.info("WORKER WITH ID " + workerID + "HAS BUILT NEW CAR");
        }
    }
}
