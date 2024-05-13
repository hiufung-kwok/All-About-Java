package fundamental.ComparableComparator.example1;

import java.util.Comparator;

public class testCarComparator implements Comparator<testCar> {
    @Override
    public int compare(testCar o1, testCar o2) {
        return o1.horsePower * o1.wheel - o2.horsePower * o2.wheel;
    }
}
