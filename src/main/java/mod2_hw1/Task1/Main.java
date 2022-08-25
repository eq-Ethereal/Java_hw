package mod2_hw1.Task1;

import mod2_hw1.Task1.bestiary.*;

public class Main {

    public static void main(String[] args) {
        Pigeon pigeon = new Pigeon();
        Pterodactylus pterodactylus = new Pterodactylus();

        MobyDick mobyDick = new MobyDick();
        MyProgrammingSkill myProgrammingSkill = new MyProgrammingSkill();

        Cat cat = new Cat();
        Alligator alligator = new Alligator();

        Zoo zoo = new Zoo(pigeon, mobyDick,cat);
        zoo.feedFlyable();
        zoo.feedBitable();
        zoo.feedSwimable();

        Zoo zoo1 = new Zoo(pterodactylus,myProgrammingSkill,alligator);
        zoo1.feedSwimable();
        zoo1.feedBitable();
        zoo1.feedSwimable();
    }
}
