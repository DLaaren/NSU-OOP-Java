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
import java.util.logging.Logger;

public class CarFactory {
    Logger log = Logger.getLogger(CarFactory.class.getName());

    private Properties properties;
    private final GeneratorID generatorID = new GeneratorID();

    private int budget;
    private int carPrice;
    private int workersSalary;
    private int sparePrice;

    private int workersCount;
    private int suppliersCount;
    private int dealersCount;

    private int workerDelay;
    private int dealerDelay;
    private int supplierDelay;

    private final Storage<Motor> motorStorage;
    private final Storage<Accessories> accessoriesStorage;
    private final Storage<CarBody> carBodyStorage;
    private final Storage<Car> carStorage;

    private ThreadPool workersThreadPool;
    private ThreadPool dealersThreadPool;
    private ThreadPool suppliersThreadPool;

    private final Task supplyMotors;
    private final Task supplyAccessories;
    private final Task supplyCarBodies;
    private final Task buildCar;
    private final Task sellCar;

    public CarFactory() throws IOException {
        properties = new Properties();
        properties.load(this.getClass().getResourceAsStream("/config.properties"));

        budget = Integer.parseInt(properties.getProperty("StartBudget"));
        carPrice = Integer.parseInt(properties.getProperty("CarPrice"));
        workersSalary = Integer.parseInt(properties.getProperty("WorkersSalary"));
        sparePrice = Integer.parseInt(properties.getProperty("SparesPrice"));

        motorStorage = new Storage<>("MotorStorage", Integer.parseInt(properties.getProperty("MotorStorageCapacity")));
        accessoriesStorage = new Storage<>( "AccessoriesStorage", Integer.parseInt(properties.getProperty("AccessoryStorageCapacity")));
        carBodyStorage = new Storage<>("CarBodyStorage", Integer.parseInt(properties.getProperty("CarBodyStorageCapacity")));
        carStorage = new Storage<>("CarStorage", Integer.parseInt(properties.getProperty("CarStorageCapacity")));

        log.info("STORAGES HAVE BEEN CREATED\n");

        workersCount = Integer.parseInt(properties.getProperty("WorkersCount"));
        suppliersCount = Integer.parseInt(properties.getProperty("SuppliersCount"));
        dealersCount = Integer.parseInt(properties.getProperty("DealersCount"));

        workerDelay = Integer.parseInt(properties.getProperty("WorkersDelay"));;
        dealerDelay = Integer.parseInt(properties.getProperty("DealersDelay"));;
        supplierDelay = Integer.parseInt(properties.getProperty("SuppliersDelay"));;


        //threadpools
        suppliersThreadPool = new ThreadPool(suppliersCount * 3);
        workersThreadPool = new ThreadPool(workersCount);
        dealersThreadPool = new ThreadPool(dealersCount);

        log.info("THREADPOOLS HAVE BEEN CREATED\n");

        //workers
        buildCar = new BuildCar(this, workersSalary, workerDelay);

        //dealers
        sellCar = new SellCar(this, carPrice, dealerDelay);

        //suppliers
        supplyMotors = new SupplySpares<Motor>(this, motorStorage, Motor.class, sparePrice, supplierDelay);
        supplyAccessories = new SupplySpares<Accessories>(this, accessoriesStorage, Accessories.class, sparePrice, supplierDelay);
        supplyCarBodies = new SupplySpares<CarBody>(this, carBodyStorage, CarBody.class, sparePrice, supplierDelay);

        log.info("TASKS HAVE BEEN CREATED\n");

        log.info("FACTORY HAS STARTED FORKING\n");
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

    public void stopCarFactory() {
        suppliersThreadPool.shutDown();
        workersThreadPool.shutDown();
        dealersThreadPool.shutDown();
        log.info("FACTORY HAS BEEN STOPPED");
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

    public int getBudget() {
        return budget;
    }
}
