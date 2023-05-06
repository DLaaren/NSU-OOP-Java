package ru.nsu.fit.vinter.carFactory.core.factory;

import ru.nsu.fit.vinter.carFactory.core.factory.spares.Accessories;
import ru.nsu.fit.vinter.carFactory.core.factory.spares.CarBody;
import ru.nsu.fit.vinter.carFactory.core.factory.spares.Motor;

public class Car extends Product{
    private final Motor motor;
    private final Accessories accessories;
    private final CarBody carBody;

    public Car(int id, Motor motor, Accessories accessories, CarBody carBody) {
        super(id);
        this.motor = motor;
        this.accessories = accessories;
        this.carBody = carBody;
    }
}
