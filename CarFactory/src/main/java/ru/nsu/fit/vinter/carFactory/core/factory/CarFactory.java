package ru.nsu.fit.vinter.carFactory.core.factory;

import ru.nsu.fit.vinter.carFactory.core.factory.products.Car;
import ru.nsu.fit.vinter.carFactory.core.factory.products.spares.Accessories;
import ru.nsu.fit.vinter.carFactory.core.factory.products.spares.CarBody;
import ru.nsu.fit.vinter.carFactory.core.factory.products.spares.Motor;
import ru.nsu.fit.vinter.carFactory.core.factory.tasks.BuildCar;
import ru.nsu.fit.vinter.carFactory.core.factory.tasks.SellCar;
import ru.nsu.fit.vinter.carFactory.core.factory.tasks.SupplySpares;
import ru.nsu.fit.vinter.carFactory.core.factory.utils.GeneratorID;
import ru.nsu.fit.vinter.carFactory.core.threadpool.Task;
import ru.nsu.fit.vinter.carFactory.core.threadpool.ThreadPool;

import java.io.IOException;
import java.util.Properties;

public class CarFactory {
    private Properties properties;
    private final GeneratorID generatorID = new GeneratorID();

    private int budget;
    private int carPrice;
    private int workersSalary;

    private Storage<Motor> motorStorage;
    private Storage<Accessories> accessoriesStorage;
    private Storage<CarBody> carBodyStorage;
    private Storage<Car> carStorage;

    private ThreadPool workersThreadPool;
    private ThreadPool dealersThreadPool;
    private ThreadPool suppliersThreadPool;

    private Task supplyMotors;
    private Task supplyAccessories;
    private Task supplyCarBodies;
    private Task buildCar;
    private Task sellCar;

    public CarFactory() throws IOException {
        properties = new Properties();
        properties.load(this.getClass().getResourceAsStream("/config.properties"));

        budget = Integer.parseInt(properties.getProperty("StartBudget"));
        carPrice = Integer.parseInt(properties.getProperty("CarPrice"));
        workersSalary = Integer.parseInt(properties.getProperty("WorkersSalary"));

        motorStorage = new Storage<>("MotorStorage", Integer.parseInt(properties.getProperty("MotorStorageCapacity")));
        accessoriesStorage = new Storage<>( "AccessoriesStorage", Integer.parseInt(properties.getProperty("AccessoryStorageCapacity")));
        carBodyStorage = new Storage<>("CarBodyStorage", Integer.parseInt(properties.getProperty("CarBodyStorageCapacity")));
        carStorage = new Storage<>("CarStorage", Integer.parseInt(properties.getProperty("CarStorageCapacity")));

        int workersCount = Integer.parseInt(properties.getProperty("WorkersCount"));
        int suppliersCount = Integer.parseInt(properties.getProperty("SuppliersCount"));
        int dealersCount = Integer.parseInt(properties.getProperty("DealersCount"));

        //thread pools
        //workersThreadPool = new ThreadPool(workersCount);
        //dealersThreadPool = new ThreadPool(dealersCount);
        //suppliersThreadPool = new ThreadPool(suppliersCount * 3);

        //workers
        buildCar = new BuildCar(this, workersSalary, Integer.parseInt(properties.getProperty("WorkersCount")));

        //dealers
        sellCar = new SellCar(this, carPrice, dealerDelay);

        //suppliers
        supplyMotors = new SupplySpares<Motor>(this, motorStorage, Motor.class, sparePrice, supplierDelay);
        supplyAccessories = new SupplySpares<Accessories>(this, accessoriesStorage, Accessories.class, sparePrice, supplierDelay);
        supplyCarBodies = new SupplySpares<CarBody>(this, carBodyStorage, CarBody.class, sparePrice, supplierDelay);

        Thread production = new Thread( () -> {
            while (carStorage.getItemCount() < carStorage.getStorageCapacity()) {
                suppliersThreadPool.addTask(supplyMotors);
                suppliersThreadPool.addTask(supplyAccessories);
                suppliersThreadPool.addTask(supplyCarBodies);
                workersThreadPool.addTask(buildCar);
                dealersThreadPool.addTask(sellCar);
            }
        });

        production.start();
    }

    public Storage<Motor> getMotorStorage() {
        return motorStorage;
    }

    public Storage<Accessories> getAccessoriesStorage() {
        return accessoriesStorage;
    }

    public Storage<CarBody> getCarBodyStorage() {
        return carBodyStorage;
    }

    public Storage<Car> getCarStorage() {
        return carStorage;
    }

    public long generateID() {
        return generatorID.generate();
    }

    public int getCarPrice() { return carPrice; }

    public void carSold(int price) {
        budget += price;
    }

    public void carBuilt(int price) {
        budget -= price;
    }

    public void sparesBought(int price) {
        budget -= price;
    }
}
