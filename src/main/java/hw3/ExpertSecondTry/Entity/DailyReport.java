package hw3.ExpertSecondTry.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Builder
@Data
@AllArgsConstructor
public class DailyReport {
    private LocalDate date;
    private double income;
    private double outcome;

}
