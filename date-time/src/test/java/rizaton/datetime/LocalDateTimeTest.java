package rizaton.datetime;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalDateTimeTest {

    @Test
    void testLocalDateTimeCreate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(1980, Month.JUNE, 10, 12, 30, 15, 456);
        LocalDateTime localDateTime2 = LocalDateTime.parse("1980-01-10T10:09:10.456123321");

        System.out.println(localDateTime);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
    }

    @Test
    void testLocalDateTimeWith() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.withYear(2020);
        LocalDateTime localDateTime2 = localDateTime1
                .withYear(2020)
                .withMonth(1)
                .withDayOfMonth(1)
                .withHour(11)
                .withMinute(22)
                .withSecond(23)
                .withNano(190234512);

        System.out.println(localDateTime);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
    }

    @Test
    void testLocalDateTimeModify() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.minusYears(10);
        LocalDateTime localDateTime2 = localDateTime1.minusHours(10);

        System.out.println(localDateTime);
        System.out.println(localDateTime1);
        System.out.println(localDateTime2);
    }

    @Test
    void testLocalDateTimeGet() {
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDateTime.getYear());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getHour());
        System.out.println(localDateTime.getMinute());
        System.out.println(localDateTime.getSecond());
        System.out.println(localDateTime.getNano());
    }

    @Test
    void testLocalDate() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println(localDate);

        LocalDateTime localDateTime1 = localDate.atTime(10, 10, 10, 10);
        System.out.println(localDateTime1);
    }

    @Test
    void testLocalTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalTime localTime = localDateTime.toLocalTime();
        System.out.println(localTime);

        LocalDateTime localDateTime1 = localTime.atDate(LocalDate.of(1980, Month.JUNE, 10));
        System.out.println(localDateTime1);
    }
}
