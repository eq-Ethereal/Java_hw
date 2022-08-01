package hw3.ExpertSecondTry.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class Store {
    private final static String SPLIT_DELIMITER = "/";
    private String shopName;
    private List<DailyReport> reports;

    public double getIncomeByMonth(Month month) {
        double result = 0.0;
        for (DailyReport report : reports) {
            if (month.equals(report.getDate().getMonth())) {
                result += report.getIncome();
            }
        }
        return result;
    }

    public double getOutcomeByMonth(Month month) {
        double result = 0.0;
        for (DailyReport report : reports) {
            if (month.equals(report.getDate().getMonth())) {
                result += report.getOutcome();
            }
        }
        return result;
    }

    public double getAllIncome() {
        double result = 0.0;
        for (DailyReport report : reports) {
            result += report.getIncome();
        }
        return result;
    }

    public double getAllOutcome() {
        double result = 0.0;
        for (DailyReport report : reports) {
            result += report.getOutcome();
        }
        return result;
    }

    public void addDailyReport(String[] s) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        for (DailyReport report : reports) {
            if (report.getDate().equals(LocalDate.parse(s[3],formatter))) {
                report.setDate(LocalDate.parse(s[3],formatter));
                report.setIncome(Double.parseDouble(s[1]));
                report.setOutcome(Double.parseDouble(s[2]));
                return;
            }
        }
        reports.add(new DailyReport(LocalDate.parse(s[3],formatter), Double.parseDouble(s[1]), Double.parseDouble(s[2])));
    }
}

