package hw4;

public class Main {
    public static void main(String[] args) {
        Human human = Human.builder().age(18).name("Durachok").weight(63).build();
        human.getInfo();
        System.out.println("___________________________________");

        CarDecorator carDecorator = new CarDecorator();
        try {
            carDecorator.sellCar();
        } catch (CarPriceException e) {
            System.out.println(e.getMesg());
        }

    }



}
