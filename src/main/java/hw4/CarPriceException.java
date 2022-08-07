package hw4;

public class CarPriceException extends Exception {
    private String message;

    public CarPriceException(String message){
        this.message = message;
    }
    public String getMesg(){
        return message;
    }
}
