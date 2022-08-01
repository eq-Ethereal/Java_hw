package hw3.ExpertSecondTry.Entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class Stores {
    private final static String SPLIT_DELIMITER = ";";
    private List<Store> stores = new ArrayList<>();

    public Stores() throws IOException {
        String pathFolder = "resource";
        File folder = new File(pathFolder);
        for (File file : folder.listFiles()) {
            List<String> lines = Files.readAllLines(file.toPath());
            for (String line : lines.subList(1, lines.size())) {
                String[] splitedText = line.split(SPLIT_DELIMITER);
                String shopName = getNameShopFromString(line);
                Store store = existStore(shopName);
                store.addDailyReport(splitedText);
                stores.add(store);
            }
        }
    }

    private Store existStore(String name) {
        if(!stores.isEmpty()) {
            for (Store store : stores) {
                if (name.equals(store.getShopName())) {
                    return store;
                }
            }
        }
        return addNewStore(name);
    }

    private String getNameShopFromString(String s) {
        String[] splitedText = s.split(SPLIT_DELIMITER);
        return splitedText[0];
    }

    private Store addNewStore(String shopName) {
        List<DailyReport> reports = new ArrayList<>();
        Store store = new Store(shopName, reports);
        stores.add(store);
        return store;
    }

    public double incomeByStoreAndMonth(String name, Month month) {
        Store store = existStore(name);
        return store.getIncomeByMonth(month);
    }

    public double outcomeByStoreAndMonth(String name, Month month) {
        Store store = existStore(name);
        return store.getOutcomeByMonth(month);
    }

    public double outcomeByStore(String name) {
        Store store = existStore(name);
        return store.getAllOutcome();
    }

    public double incomeByStore(String name) {
        Store store = existStore(name);
        return store.getAllIncome();
    }

}

