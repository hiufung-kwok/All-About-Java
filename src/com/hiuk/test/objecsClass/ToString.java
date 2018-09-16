package com.hiuk.test.objecsClass;


import java.util.Objects;

/**
 * Ref: https://dzone.com/articles/stringvalueofobject-versus-objectstostringobject?utm_medium=feed&utm_source=feedpress.me&utm_campaign=Feed:%20dzone%2Fjava
 *
 * Different do exist between String.valueOf(Object), Objects.toString(Object)
 */
public class ToString {


    private static void print (String s1, String s2) {
        System.out.printf("[%s,%s]\n",s1, s2);
    }

    public static void main(String[] args) {

        int sum = 10;

        print(String.valueOf(sum)  , Objects.toString(sum) );
//        valueOf(null) Would cause a null pointer exception but Objects.toString dun.
//        String.valueOf(null)
        
//      But Objects.toString( ) don't.
        System.out.println(Objects.toString(null) );

    }
}
