package hw2;

import java.util.HashSet;
import java.util.Map;

public class Main {
    private static final String SPECIAL_CAR_NUMBER_MATCH = "^М\\d{3}АВ\\d{2,3}";

    public static void main(String[] args) {
        migrationCount(GeneratorExpertHomework.getData());
    }

    private static void migrationCount(Map<Integer, Map<String, String[]>> data) {
        HashSet<String> specCarNumbers = new HashSet<>();
        data.forEach((integer, stringMap) -> stringMap.forEach((s, strings) -> {
            for (String carNumber :
                    strings) {
                if (carNumber.matches(SPECIAL_CAR_NUMBER_MATCH)) {
                    specCarNumbers.add(carNumber);
                }
            }
        }));
        System.out.println("Уровень миграции машин со спец номерами : " + specCarNumbers.size() + " ед. в месяц");
        System.out.println("Пойманы с поличным: " + specCarNumbers.toString());
    }
}
