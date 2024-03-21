package designPattern.Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class iteratorTest {

    public static void main(String[] args) {


        //Basic use of iterator.
        // However, this usage is obsoleted, better to call for-each and skip iterator completely.
        List<String> al = Arrays.asList("1", "2", "3", "4", "5");
        Iterator<String> iterator = al.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
