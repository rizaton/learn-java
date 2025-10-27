package rizaton.datetime;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Calendar;

public class LocalDateTest {
    @Test
    void testCreateLocalDate() {
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = LocalDate.of(1980, Month.JUNE, 10);
        LocalDate localDate3 = LocalDate.parse("1980-01-10");

        System.out.println(localDate1);
        System.out.println(localDate2);
        System.out.println(localDate3);

    }

    @Test
    void testLocalDateWith() {
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = localDate1.withYear(2000);
        LocalDate localDate3 = localDate2.withYear(2012).withMonth(11);

        System.out.println(localDate1);
        System.out.println(localDate2);
        System.out.println(localDate3);

    }

    @Test
    void testLocalDateManipulate() {
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = localDate1.minusYears(10);
        LocalDate localDate3 = localDate2
                .minusDays(5)
                .minusWeeks(1)
                .minusMonths(3)
                .minusYears(10);

        System.out.println(localDate1);
        System.out.println(localDate2);
        System.out.println(localDate3);
    }

    @Test
    void testLocalDateGetLocalDate() {
        LocalDate localDate1 = LocalDate.now();
        LocalDate localDate2 = localDate1.minusYears(10);
        LocalDate localDate3 = localDate2
                .minusDays(5)
                .minusWeeks(1)
                .minusMonths(3)
                .minusYears(10);

        System.out.println(localDate1.getYear());
        System.out.println(localDate1.getDayOfYear());
        System.out.println(localDate3.getEra());
    }
}
