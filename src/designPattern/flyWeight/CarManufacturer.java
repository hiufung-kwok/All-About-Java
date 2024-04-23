package designPattern.flyWeight;

/**
 * No setter available, as FlyWeight object is immutable.
 */
public class CarManufacturer {

    private String name;

    private String countryOfOrigin;

    private int capital;

    public CarManufacturer(String name, String countryOfOrigin, int capital) {
        this.name = name;
        this.countryOfOrigin = countryOfOrigin;
        this.capital = capital;
    }
}
