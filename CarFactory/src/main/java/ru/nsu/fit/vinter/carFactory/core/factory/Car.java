package ru.nsu.fit.vinter.carFactory.core.factory;

import ru.nsu.fit.vinter.carFactory.core.factory.spares.Accessories;
import ru.nsu.fit.vinter.carFactory.core.factory.spares.CarBody;
import ru.nsu.fit.vinter.carFactory.core.factory.spares.Motor;

public class Car extends Product {
    private Motor motor;
    private Accessories accessories;
    private CarBody carBody;

    public Car(int id) {
        super(id);
    }

    public void installMotor(Motor motor) {
        this.motor = motor;
    }

    public void installAccessories(Accessories accessories) {
        this.accessories = accessories;
    }

    public void installCarBody(CarBody carBody) {
        this.carBody = carBody;
    }

    public Car finishBuildCar() {
        return new Car(getID());
    }
}
