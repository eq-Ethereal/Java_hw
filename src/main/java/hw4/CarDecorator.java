package hw4;

import java.util.ArrayList;
import java.util.List;

public class CarDecorator {
    Car car;

    public CarDecorator() {
        car = new Car();
    }
    public void sellCar() throws CarPriceException {
        System.out.println("Hello, price of the car: ");
        car.printPrice();
        System.out.println("Do you wonna buy it?");
    }

}
