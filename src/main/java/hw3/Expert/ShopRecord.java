package hw3.Expert;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data @AllArgsConstructor
public class ShopRecord {
    private String shop;
    private double income;
    private double outcome;
    private String date; // можно и Date
}
