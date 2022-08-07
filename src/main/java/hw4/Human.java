package hw4;

public class Human {
    private String name;
    private int age;
    private int weight;

//    private Human(String name, int age, int weight) {
//        this.name = name;
//        this.age = age;
//        this.weight = weight;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void getInfo() {
        System.out.println(name + " " + weight + " " + age);
    }
    public static HumanBuilder builder(){
        return new HumanBuilder();
    }

    public static class HumanBuilder {
        private Human human;

        public Human build() {
            return this.human;
        }

        public HumanBuilder() {
            this.human = new Human();
        }

        public HumanBuilder age(int age) {
            human.setAge(age);
            return this;
        }

        public HumanBuilder name(String name) {
            human.setName(name);
            return this;
        }

        public HumanBuilder weight(int weight) {
            human.setWeight(weight);
            return this;
        }

    }

}

