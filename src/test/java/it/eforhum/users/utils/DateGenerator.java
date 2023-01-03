package it.eforhum.users.utils;

import java.time.*;
import java.util.Random;

public class DateGenerator {
    private DateGenerator() {
        // Do Nothing
    }
    private static Random randomGenerator = new Random();

    private static long MAX_EPOCH_DAY = 1672527600000L;
    private static long MIN_EPOCH_DAY = 0L;
    public static Long randomEpochDay() {
        return (long) (Math.random() * (MAX_EPOCH_DAY - MIN_EPOCH_DAY)) + MIN_EPOCH_DAY;
    }
    public static Long randomEpochDay(long max_epoch_day) {
        long epoch_day = Math.abs(max_epoch_day);
        return (long) (Math.random() * (epoch_day - MIN_EPOCH_DAY + 1)) + MIN_EPOCH_DAY;
    }

    public static LocalDate randomLocalDate() {
        return LocalDate.now();
    }

    public static LocalDate randomLocalDate(LocalDate min, LocalDate max) {
        return randomLocalDate();
    }

    public static LocalDate defaultLocalDate() {
        return LocalDate.of(1970, 1, 1);
    }

    public static ZonedDateTime defaultZonedDateTime() {
        return ZonedDateTime.of(DateGenerator.randomLocalDate(), LocalTime.of(0, 0, 0), ZoneId.systemDefault());
    }
}
