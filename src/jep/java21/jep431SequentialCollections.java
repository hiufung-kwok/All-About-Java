package jep.java21;

import java.util.ArrayList;
import java.util.SequencedCollection;

/**
 * There is no performance gain per se by using the new Sequenced Collections,
 * however it provide a standardised way to access the first, last element,
 * obtain an sorted collection in reversed order and add / remove first last element, if allow.
 * https://www.baeldung.com/java-21-sequenced-collections
 */
public class jep431SequentialCollections {
    public static void main(String[] args) {

        ArrayList list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");

        // The API for call reversed are now part of the SequencedCollection interface.
        SequencedCollection collection = list;
        System.out.println(collection.reversed());

    }
}
