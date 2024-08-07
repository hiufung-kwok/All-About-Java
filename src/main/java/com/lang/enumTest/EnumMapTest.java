package com.lang.enumTest;

import java.util.EnumMap;



public class EnumMapTest {
    public static void main(String[] args) {
        EnumMap<Color, String> colorMap = new EnumMap<>(Color.class);
        colorMap.put(Color.RED, "Red Color");
        colorMap.put(Color.GREEN, "Green Color");

        System.out.println(colorMap);
    }

    enum Color {
        RED, GREEN, BLUE
    }
}
