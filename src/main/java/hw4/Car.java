package hw4;

import java.util.Random;

public class Car {
    private int price;
    static Random random = new Random();

    public Car () {
        price = random.nextInt(50_000)-40_000;
    }

    public void printPrice() throws CarPriceException {
        if (price > 0) {
            System.out.println(price);
        }else if(price==0) {
            System.out.println("its free, man, just take and go");
        }
        else {
            throw new CarPriceException("Тебе еще заплатят если возьмешь это корыто, но наш софт не может такое продать кек");
        }

    }
}
