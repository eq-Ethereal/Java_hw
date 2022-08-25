package mod2_hw1.Task1;

public class Zoo <T extends Flayable, V extends Swimable, E extends Bitable>  {
    private T flyingPet;
    private V swimabalePet;
    private E bitablePet;

    public Zoo(T flyingPet, V swimabalePet, E bitablePet) {
        this.flyingPet = flyingPet;
        this.swimabalePet = swimabalePet;
        this.bitablePet = bitablePet;
    }

    public T getFlyingPet() {
        return flyingPet;
    }

    public void setFlyingPet(T flyingPet) {
        this.flyingPet = flyingPet;
    }

    public V getSwimabalePet() {
        return swimabalePet;
    }

    public void setSwimabalePet(V swimabalePet) {
        this.swimabalePet = swimabalePet;
    }

    public E getBitablePet() {
        return bitablePet;
    }

    public void setBitablePet(E bitablePet) {
        this.bitablePet = bitablePet;
    }

    public void feedFlyable() {
        System.out.println("Летающее животное хавает вкусняшку");
        flyingPet.fly();
    }

    public void feedSwimable() {
        System.out.println("Карась пьет пиво");
        swimabalePet.swim();
    }

    public void feedBitable() {
        System.out.println("Кушать не получил так как кусается");
        bitablePet.bite();
    }

}
