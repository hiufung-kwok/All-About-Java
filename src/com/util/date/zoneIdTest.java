package com.util.date;

import java.time.DateTimeException;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class zoneIdTest {
    public static void main(String[] args) {
        ZoneId.getAvailableZoneIds()
                .forEach(System.out::println);


        ZonedDateTime zdt = ZonedDateTime.now();
        System.out.println(zdt);
        ZonedDateTime newZdt = zdt.withZoneSameInstant(ZoneId.of("Pacific/Auckland"));
        System.out.println(newZdt);

        // Instant represent time in UTC, hence below two will be identical.
        System.out.println(zdt.toInstant());
        System.out.println(newZdt.toInstant());


        try {
            ZoneId.of("tes");

        } catch (DateTimeException ex) {
            System.out.println(ex.getMessage());
        }




    }
}
