package com.bookref.effectiveJava.methods;


import java.util.*;

/**
 * Never ever return null, return a empty if null.
 *
 * Item: 54-55
 */
public class DunEverReturtnNull {


    /**
     * In this case, even incoming collection is null, a empty collection would be return.
     * In order to prevent null problem.
     * @param incoming
     * @return
     */
    private static List<String> getMetSomeThing (List<String> incoming){
        return new ArrayList<String>(incoming);
    }


    /**
     * Avoid keep allocate empty collection, point into static EmptyList instead.
     * @param incoming
     * @return
     */
    private static List<String> getOptimalThing (List<String> incoming){
        return incoming.isEmpty() ? Collections.emptyList() : new ArrayList<>(incoming);
    }

    /**
     * Wrap it with optional if null is unavoidable or exception is thrown. Exception is costy.
     */
    private static Optional<Integer> Nullable(List<Integer> items){
        if (items == null || items.isEmpty()) {
            return Optional.empty();
        }else{
            //Always the first number
            return  items.stream().max(Comparator.naturalOrder() );
        }
    }

}
