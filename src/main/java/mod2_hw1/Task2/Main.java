package mod2_hw1.Task2;

public class Main {
    public static void main(String[] args) {
        MyList<Object> myList = new MyList<>();
        Object object = new Object();
        myList.add(object);
        System.out.println(myList);
        myList.add(object);
        myList.add(object);
        System.out.println(myList);
        myList.add(object);
        System.out.println(myList);
    }
}
