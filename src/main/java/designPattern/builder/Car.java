package designPattern.builder;

/**
 * This calss is designed to be immutable
 */
public class Car {
    private final String brandName;

    private final String modelName;

    private final int seats;

    public Car(String brandName, String modelName, int seats) {
        this.brandName = brandName;
        this.modelName = modelName;
        this.seats = seats;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getModelName() {
        return modelName;
    }

    public int getSeats() {
        return seats;
    }
}
