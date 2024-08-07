package designPattern.flyWeight;

/**
 * Instead of storing duplicate info for manufacturer, getting it from the factory object instead.
 */
public class Car {

    private CarManufacturer manufacturer;

    private String model;

    private int price;

    public Car(String model, int price,
               String manufactureName, String manufactureCountryOfOrigin, int manufactureCapital) {
        this.manufacturer = CarFactory.getCarManufacturer(manufactureName, manufactureCountryOfOrigin, manufactureCapital);
        this.model = model;
        this.price = price;
    }
}
