package hw3.ExpertSecondTry;

import hw3.ExpertSecondTry.Entity.Stores;

import java.io.IOException;
import java.time.Month;

public class Main {


    public static void main(String[] args) throws IOException {
        Stores stores = new Stores();
        incomeMinusOutcomeByMonth("pyterochka", stores);
//        income(stores, "pyterochka");
//        income(stores, "perekrestok");
//        income(stores, "ydoma");
//        income(stores, "okey");

        outcome(stores, "pyterochka");
        outcome(stores, "perekrestok");
        outcome(stores, "ydoma");
        outcome(stores, "okey");

    }

    private static void incomeMinusOutcomeByMonth(String s, Stores stores) {
        for (int i = 1; i < 13; i++) {
            System.out.println(i + " 2012: " + (stores.incomeByStoreAndMonth(s, Month.of(i)) - stores.outcomeByStoreAndMonth(s, Month.of(i))));
        }
    }

    private static void income(Stores stores, String s) {
        System.out.println(s + " " + stores.incomeByStore(s));
    }

    private static void outcome(Stores stores, String s) {
        System.out.println(s + " " + stores.outcomeByStore(s));
    }
}
