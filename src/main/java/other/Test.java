package other;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.WeakHashMap;

public class Test {
    public static void main(String[] args) {

//        Optional<String> optionalString = Optional.of("Test");
//        System.out.println(optionalString.orElse("I'm an empty String"));
//
//
//        // To sort a list
//        List<Integer> list = Arrays.asList(100, 500, 300);
//
//        System.out.println(list);
//        // Do a reverse sort, same as
//        list.sort((a, b) -> b.compareTo(a));
//        // This
//        list.sort(Comparator.reverseOrder());
//        System.out.println();
//
//        LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant();
//
//        List<Integer> numList = List.of(1,1,1,2,3,4,5);
//        System.out.println(numList.stream()
//                .distinct()
//                .map(x -> x*x)
//                .skip(1)
//                .reduce(Integer::sum).get());
//
//        System.out.println(numList.stream()
//                .min(Comparator.naturalOrder())
//                .get());
//
//        Optional<String> str = Optional.of("test");
//        str.ifPresent(System.out::println);
//
//


        String h = "Hello";
        String w = " world";

        int num = 1234;

//        System.out.println(h.substring(1));
        System.out.println(String.valueOf(num).substring(0, 2));


        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        System.out.println(h.concat(w));
        Map<Integer, Integer> weakhashMap = new WeakHashMap<>();

    }
}


