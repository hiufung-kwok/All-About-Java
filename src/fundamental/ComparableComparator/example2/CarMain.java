package fundamental.ComparableComparator.example2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarMain {

    public static void main(String[] args) {


        List<PlainPojoCar> cars = new ArrayList<>();

        cars.add(new PlainPojoCar("Toyota", 30 , 30));
        cars.add(new PlainPojoCar("Tesla", 10 , 10));
        cars.add(new PlainPojoCar("Honda", 20 , 20));

        cars.sort(new CarComparator());
        for (PlainPojoCar car: cars) {
            System.out.println(car);
        }

    }
}

class CarComparator implements Comparator<PlainPojoCar> {

    @Override
    public int compare(PlainPojoCar o1, PlainPojoCar o2) {


        return o2.customerPreference - o1.customerPreference;
    }
}

