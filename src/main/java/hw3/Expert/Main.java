package hw3.Expert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    private final static String SPLIT_DELIMITER = ";";

    public static void main(String[] args) throws IOException {
        System.out.println(readReports());
    }

    private static HashMap<Integer, List<ShopRecord>> readReports() throws IOException {
        String pathFolder = "resource";
        List<ShopRecord> reports = new ArrayList<>();
        HashMap<Integer, List<ShopRecord>> totalReports = new HashMap<>();
        File folder = new File(pathFolder);
        int month = 1;
        for (File file : folder.listFiles()) {
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

    }
}
