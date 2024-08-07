package collection.list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayLInkedListTest {

    public static void main(String[] args) {
        final List<String> resultArrayList = new ArrayList<>();
        final List<String> resultLinkedList = new LinkedList<>();

        resultArrayList.add("test string");
        resultArrayList.remove(0);
        // Super-fast,as it's backed by an array.
        resultArrayList.get(0);

        resultLinkedList.add("Test linked list ");
        // Super low as it's need to traverse either from the first,
        // or the last element, until it reach the destination.
        resultLinkedList.get(1);

    }
}
