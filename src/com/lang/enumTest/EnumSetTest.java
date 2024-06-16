package com.lang.enumTest;

import java.util.HashSet;
import java.util.Set;

public class EnumSetTest {
    public static void main(String[] args) {
        Set<Color> colorSet = new HashSet<>();
        colorSet.add(Color.RED);
        colorSet.add(Color.GREEN);

        System.out.println(colorSet);
    }

    enum Color {
        RED, GREEN, BLUE
    }
}
