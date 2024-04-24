package designPattern.builder;

public class CarBuilder implements Builder {

    private String brand;

    private String modelName;

    private int seats;

    @Override
    public void setCarBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public void setModelName(String name) {
        this.modelName = name;
    }

    @Override
    public void setSeat(int seats) {
        this.seats = seats;
    }

    public Car getResult() {
        return new Car(brand, modelName, seats);
    }
}
