package ru.nsu.fit.vinter.carFactory.core.factory;

import ru.nsu.fit.vinter.carFactory.core.factory.spares.Accessories;
import ru.nsu.fit.vinter.carFactory.core.factory.spares.CarBody;
import ru.nsu.fit.vinter.carFactory.core.factory.spares.Motor;
import ru.nsu.fit.vinter.carFactory.core.threadpool.Task;
import ru.nsu.fit.vinter.carFactory.core.threadpool.ThreadPool;

import java.io.IOException;
import java.util.Properties;

public class CarFactory {
    private Properties properties;
    private final GeneratorID generatorID = new GeneratorID();

    private int budget;

    private final Storage<Motor> motorStorage;
    private final Storage<Accessories> accessoriesStorage;
    private final Storage<CarBody> carBodyStorage;
    private final Storage<Car> carStorage;

    private final ThreadPool workersThreadPool;
    private final ThreadPool dealersThreadPool;
    private final ThreadPool suppliersThreadPool;

    Task supplyMotors;
    Task supplyAccessories;
    Task supplyCarBodies;
    Task build;
    Task sell;

    public CarFactory() throws IOException {
        properties = new Properties();
        properties.load(this.getClass().getResourceAsStream("/config.properties"));

        budget = Integer.parseInt(properties.getProperty("budget"));

        motorStorage = new Storage<>("MotorStorage", Integer.parseInt(properties.getProperty("MotorStorageCapacity")));
        accessoriesStorage = new Storage<>( "AccessoriesStorage", Integer.parseInt(properties.getProperty("AccessoryStorageCapacity")));
        carBodyStorage = new Storage<>("CarBodyStorage", Integer.parseInt(properties.getProperty("CarBodyStorageCapacity")));
        carStorage = new Storage<>("CarStorage", Integer.parseInt(properties.getProperty("CarStorageCapacity")));

        int workersCount = Integer.parseInt(properties.getProperty("Workers"));
        int suppliersCount = Integer.parseInt(properties.getProperty("Suppliers"));
        int dealersCount = Integer.parseInt(properties.getProperty("Dealers"));

        //thread pools
        workersThreadPool = new ThreadPool(workersCount);
        dealersThreadPool = new ThreadPool(dealersCount);
        suppliersThreadPool = new ThreadPool(suppliersCount * 3);

        //workers
        build = ;

        //dealers
        sell = ;

        //suppliers
        supplyMotors = ;
        supplyAccessories = ;
        supplyCarBodies = ;

        Thread production = new Thread( () -> {
            while () {

            }
        });

        production.start();
    }



}
