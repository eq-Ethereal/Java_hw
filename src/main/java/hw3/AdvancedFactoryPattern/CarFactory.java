package hw3.AdvancedFactoryPattern;

public class CarFactory {
    Car car = null;
    public static Car createCar(CarType carType) {
        Car car;
        switch (carType){
            case Lada:
                car = new Lada();
                break;
            case Toyota:
                car = new Toyota();
                break;
            default:
                throw new IllegalArgumentException("Wrong car type: " + carType);
        }
        return car;
    }

}
