package jep.java11;


import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * It seems redundant, as Lambda can do type inference by default since Java8.
 * However, with the additional `var`, now it's possible to do annotation also.
 */
public class jep323varInLambda {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "b", "c");
        String result = list.stream()
                .map((@NotNull var x) -> x.toUpperCase())
                .collect(Collectors.joining(","));
    }
}
