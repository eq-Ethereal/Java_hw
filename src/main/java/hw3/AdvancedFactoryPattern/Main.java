package hw3.AdvancedFactoryPattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int ladaAmount = 0;
        int toyotaAmount = 0;

        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            cars.add(CarFactory.createCar(randomEnum(CarType.class)));
        }
        for (Car car : cars) {
            if (car instanceof Lada) {
                ((Lada) car).crash();
                ladaAmount++;
            }
            if (car instanceof Toyota) {
                ((Toyota) car).music();
                toyotaAmount++;
            }
        }
        System.out.println("Amount of toyota : " + toyotaAmount + "\nAMount of Lada : " + ladaAmount);

    }

    //скомунячено
    public static <T extends Enum<?>> T randomEnum(Class<T> clazz) {
        Random random = new Random();
        int x = random.nextInt(clazz.getEnumConstants().length);
        return clazz.getEnumConstants()[x];
    }
}
