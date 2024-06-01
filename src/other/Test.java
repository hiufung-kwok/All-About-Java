package other;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        System.out.println(date);


        LocalTime time = LocalTime.now();
        System.out.println(time);


        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ldt);

        // Parse a String to Date
        LocalDate stringDate = LocalDate.parse("2023-05-31");
        System.out.println(stringDate);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(stringDate.format(formatter));

        System.out.println(Instant.now());

        // Add 5 days
        System.out.println(date.plusDays(5));

        // - 3 hrs
        System.out.println(time.minusHours(3));

        // Between two dates
        System.out.println(Period.between(stringDate, LocalDate.now()));

        // Between two times
        System.out.println(Duration.between(LocalTime.now(), LocalTime.now().minusHours(5)));

        // LocalDateTime -> Instant
        Instant instant = LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant();
        System.out.println(instant);

        // Get date of the week
        System.out.println(LocalDate.now().getDayOfWeek());
        // Month
        System.out.println(LocalDate.now().getMonth());

        // Construct a LocalDate (Non String).
        System.out.println(LocalDate.of(2024, Month.AUGUST, 21));

        // Specific time
        System.out.println(LocalTime.of(17, 50));

        // Parse date and time
        System.out.println(LocalDateTime.parse("2023-05-31T14:30:00"));

        Optional<String> optionalString = Optional.of("Test");
        System.out.println(optionalString.orElse("I'm an empty String"));


        // To sort a list
        List<Integer> list = Arrays.asList(100, 500, 300);

        System.out.println(list);
        // Do a reverse sort, same as
        list.sort((a, b) -> b.compareTo(a));
        // This
        list.sort(Comparator.reverseOrder());
        System.out.println();



















    }
}


