package ru.nsu.fit.vinter.carFactory.core.factory;

import ru.nsu.fit.vinter.carFactory.core.factory.spares.Accessories;
import ru.nsu.fit.vinter.carFactory.core.factory.spares.CarBody;
import ru.nsu.fit.vinter.carFactory.core.factory.spares.Motor;
import ru.nsu.fit.vinter.carFactory.core.threadpool.ThreadPool;

import java.util.Properties;

public class CarFactory {
    private Properties properties;

    private final Storage<Motor> motorStorage;
    private final Storage<Accessories> accessoriesStorage;
    private final Storage<CarBody> carBodyStorage;
    private final Storage<Car> carStorage;

    private final ThreadPool workers;
    private final ThreadPool dealers;
    private final ThreadPool suppliers;

    public CarFactory() {
        properties = new Properties();
        properties.load(this.getClass().getResourceAsStream("/config.properties"));

        motorStorage = new Storage<>("MotorStorage", Integer.parseInt(properties.getProperty("MotorStorageCapacity")));
        accessoriesStorage = new Storage<>( "AccessoriesStorage", Integer.parseInt(properties.getProperty("AccessoryStorageCapacity")));
        carBodyStorage = new Storage<>("CarBodyStorage", Integer.parseInt(properties.getProperty("CarBodyStorageCapacity")));
        carStorage = new Storage<>("CarStorage", Integer.parseInt(properties.getProperty("CarStorageCapacity")));

        int workersCount = Integer.parseInt(properties.getProperty("Workers"));
        int suppliersCount = Integer.parseInt(properties.getProperty("Suppliers"));
        int dealersCount = Integer.parseInt(properties.getProperty("Dealers"));


    }

}
