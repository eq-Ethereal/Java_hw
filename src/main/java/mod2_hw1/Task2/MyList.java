package mod2_hw1.Task2;

import java.util.ArrayList;
import java.util.Arrays;

public class MyList<T> {
    private T[] objects = (T[]) new Object[3];
    private int size = 0;

    public MyList() {
    }

    public boolean add(T object) {
        if (objects.length == size) {
            T[] newObjects = (T[]) new Object[objects.length * 2];
//            System.arraycopy(objects, 0, newObjects, 0, objects.length);
            for (int i = 0; i < objects.length; i++) {
                newObjects[i] = objects[i];
            }
            objects = newObjects;
        }
        for (int i = 0; i < objects.length; i++) {
            if (objects[i] == null) {
                objects[i] = object;
                size++;
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "MyList{" +
                "objects=" + Arrays.toString(objects) +
                '}';
    }
}
