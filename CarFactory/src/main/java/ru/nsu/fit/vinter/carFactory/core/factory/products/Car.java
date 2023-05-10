package ru.nsu.fit.vinter.carFactory.core.factory.products;

import ru.nsu.fit.vinter.carFactory.core.factory.products.spares.Accessories;
import ru.nsu.fit.vinter.carFactory.core.factory.products.spares.CarBody;
import ru.nsu.fit.vinter.carFactory.core.factory.products.spares.Motor;

public class Car extends Product {
    private Motor motor;
    private Accessories accessories;
    private CarBody carBody;

    public Car(long id) {
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
