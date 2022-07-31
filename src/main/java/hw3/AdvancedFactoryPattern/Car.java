package hw3.AdvancedFactoryPattern;

public abstract class Car {
    private boolean lights = false;

    public void startMoving() {
        System.out.println("Car start moving");
    }

    public void stopMoving() {
        System.out.println("Car stop moving");
    }

    public void switchLights() {
        lights = !lights;
        System.out.println(lights);
    }

}
