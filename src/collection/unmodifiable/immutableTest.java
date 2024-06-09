package collection.unmodifiable;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

/**
 * Yes, indeed update / delete is prohibited on the unmodifiable collection
 * level, however it's not a clone of the original collection, but a view.
 * So when the underneath collection changed, the view will also reflect that changes.
 */
public class immutableTest {


    public static void main(String[] args) {

        var arr = new ArrayList<String>();


        arr.add("ca");
        arr.add("us");
        arr.add("au");

        // The unmodifiable are same as List.of, and clone / deep copy won't work if one level is involved.
        var readOnlyListView = Collections.unmodifiableList(arr);
        var immutableList = List.of(arr);
        // Below are immutable.
//        var readOnlyListView = Collections.unmodifiableList(new ArrayList<>(arr));
//        var immutableList = List.of(new ArrayList<>(arr));


        System.out.println("Before: ");
        readOnlyListView.forEach(System.out::println);
        arr.add("uk");

        // UK is now shown on the print as well.
        System.out.println("After - UnmodifiableList: ");
        readOnlyListView.forEach(System.out::println);

        // Same.
        System.out.println("After - Immutable: ");
        immutableList.forEach(System.out::println);


        try {
            readOnlyListView.add("test");
        } catch (UnsupportedOperationException ex) {
            System.out.println("Can't be updated.");
        }


        // Customer comparator
        TreeSet<String> ts = new TreeSet<>(
                (var s1, var s2) -> Integer.compare(s1.length(), s2.length()+10));













    }
}
