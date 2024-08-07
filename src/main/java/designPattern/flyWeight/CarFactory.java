package designPattern.flyWeight;

import java.util.HashMap;
import java.util.Map;

/**
 * Return cached object, if it's exist.
 */
public class CarFactory {
    static Map<String, CarManufacturer> carManufacturerMap = new HashMap<>();

    public static CarManufacturer getCarManufacturer(String name, String countryOfOrigin, int capital) {
        CarManufacturer manufacturer = carManufacturerMap.get(name);
        if (manufacturer == null) {
            manufacturer = new CarManufacturer(name, countryOfOrigin, capital);
            carManufacturerMap.put(name, manufacturer);
        }
        return manufacturer;
    }
}
