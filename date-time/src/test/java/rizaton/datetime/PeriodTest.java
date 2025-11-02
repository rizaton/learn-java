package rizaton.datetime;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;

public class PeriodTest {

    @Test
    void testCreate() {
        Period period1 = Period.ofDays(10);
        Period period2 = Period.ofWeeks(10);
        Period period3 = Period.ofMonths(10);
        Period period4 = Period.ofYears(10);
        Period period5 = Period.of(10, 10, 10);

        System.out.println(period1);
        System.out.println(period2);
        System.out.println(period3);
        System.out.println(period4);
        System.out.println(period5);
    }

    @Test
    void testGet() {
        Period period1 = Period.of(10, 10, 10);

        System.out.println(period1.getYears());
        System.out.println(period1.getMonths());
        System.out.println(period1.getDays());
    }

    @Test
    void testBetween() {
        Period period1 = Period.between(
                LocalDate.of(2020, 10, 10),
                LocalDate.of(2025, 1, 2)
        );

        System.out.println(period1.getYears());
        System.out.println(period1.getMonths());
        System.out.println(period1.getDays());
    }
}
