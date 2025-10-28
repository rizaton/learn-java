package rizaton.datetime;

import org.junit.jupiter.api.Test;

import java.time.*;

public class YearTest {
    @Test
    void testCreate() {
        Year year = Year.now();
        Year year1 = Year.of(2018);
        Year year2 = Year.parse("1980");

        System.out.println(year);
        System.out.println(year1);
        System.out.println(year2);

        YearMonth yearMonth = YearMonth.now();
        YearMonth yearMonth1 = YearMonth.of(2018, Month.JUNE);
        YearMonth yearMonth2 = YearMonth.parse("2018-09");

        System.out.println(yearMonth);
        System.out.println(yearMonth1);
        System.out.println(yearMonth2);

        MonthDay monthDay = MonthDay.now();
        MonthDay monthDay1 = MonthDay.of(Month.DECEMBER, 31);
        MonthDay monthDay2 = MonthDay.parse("--10-09");

        System.out.println(monthDay);
        System.out.println(monthDay1);
        System.out.println(monthDay2);

    }

    @Test
    void testYearConversion() {
        Year year = Year.now();
        YearMonth yearMonth = year.atMonth(Month.JUNE);
        System.out.println(yearMonth);

        LocalDate localDate = yearMonth.atDay(1);
        System.out.println(localDate);

        MonthDay monthDay = MonthDay.from(localDate);
        System.out.println(monthDay);
    }

    @Test
    void testYearGet() {
        Year year = Year.now();
        YearMonth yearMonth = YearMonth.now();
        MonthDay monthDay = MonthDay.now();

        System.out.println(year.getValue());

        System.out.println(yearMonth.getYear());
        System.out.println(yearMonth.getMonth());

        System.out.println(monthDay.getMonth());
        System.out.println(monthDay.getDayOfMonth());
    }
}
