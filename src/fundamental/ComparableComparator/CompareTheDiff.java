package fundamental.ComparableComparator;

import java.sql.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * The main different is that Comparable usually implements
 * alongside with the actual class definition, so there will only be
 * one definition.
 * However, Comparator on the other side, usually be implemented as
 * a standalone class, in this way you can keep multiple pairs of comparator
 * for different purpose, which Comparable can't. Ex: Collections.sort();
 */
public class CompareTheDiff {

    public static void main(String[] args) {


        List<testCar> testCarList = Arrays.asList(
                new testCar(1,2),
                new testCar(2, 4)
        );

        // Sort by comparator.
        testCarList.sort(new testCarComparator());


    }
}
