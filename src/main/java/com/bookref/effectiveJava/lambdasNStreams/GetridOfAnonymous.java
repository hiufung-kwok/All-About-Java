package com.bookref.effectiveJava.lambdasNStreams;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * Effective Java: 42
 */
public class GetridOfAnonymous {


    public static void main(String[] args) {
//        Lambda >>>>> Anonymous class
        Collections.sort(Arrays.asList(1,2,3), new Comparator<Integer>() {

            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });

//        Proper way
        Collections.sort(Arrays.asList(1,2,3,4), (s1, s2) -> s1-s2);
    }
}
