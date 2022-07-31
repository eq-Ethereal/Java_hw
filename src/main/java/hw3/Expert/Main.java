package hw3.Expert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private final static String SPLIT_DELIMITER = ";";

    public static void main(String[] args) throws IOException {
        firstTask(readReports());
        secondTask(readReports());
    }

    private static HashMap<Integer, List<ShopRecord>> readReports() throws IOException {
        String pathFolder = "resource";
        HashMap<Integer, List<ShopRecord>> totalReports = new HashMap<>();
        File folder = new File(pathFolder);
        int month = 1;
        for (File file : folder.listFiles()) {
            List<ShopRecord> reports = new ArrayList<>();
            List<String> lines = Files.readAllLines(file.toPath());
            for (String line : lines.subList(1, lines.size())) {
                month = Integer.parseInt(file.getName().substring(file.getName().indexOf('_') + 1, file.getName().lastIndexOf('_')));
                reports.add((fillPojoShopRecord(line)));
            }
            totalReports.put(month, reports);

        }
        return totalReports;
    }


    private static ShopRecord fillPojoShopRecord(String s) {
        String[] splitedText = s.split(SPLIT_DELIMITER);
        return ShopRecord.builder()
                .shop(splitedText[0])
                .income(Double.parseDouble(splitedText[1]))
                .outcome(Double.parseDouble(splitedText[2]))
                .date(splitedText[3])
                .build();
    }

    private static void firstTask(HashMap<Integer, List<ShopRecord>> totalReports) {
        for (int i = 1; i < 13; i++) {
            double income = 0;
            double outcome = 0;
            List<ShopRecord> monthReport = totalReports.get(i);
            for (int j = 0; j < monthReport.size(); j++) {
                if (monthReport.get(j).getShop().contains("pyterochka")) {
                    income += monthReport.get(j).getIncome();
                    outcome += monthReport.get(j).getOutcome();
                }
            }
            System.out.println(i + ".2012 final : " + (income - outcome));
        }
    }

    private static void secondTask(HashMap<Integer, List<ShopRecord>> totalReports) {
        Map<String, Double> map = new HashMap<>();
        for (int i = 1; i < 13; i++) {
            List<ShopRecord> monthReport = totalReports.get(i);
            for (int j = 0; j < monthReport.size(); j++) {
                if (map.containsKey(monthReport.get(j).getShop())) {
                    Double out = map.get(monthReport.get(j).getShop());
                    map.put(monthReport.get(j).getShop(), out + monthReport.get(j).getOutcome());
                } else {
                    map.put(monthReport.get(j).getShop(), +monthReport.get(j).getOutcome());
                }
            }
        }
        System.out.println(map);
    }
}
