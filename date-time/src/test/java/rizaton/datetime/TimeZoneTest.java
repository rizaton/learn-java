package rizaton.datetime;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeZoneTest {

    @Test
    void testTimezone() {
        TimeZone timeZone1 = TimeZone.getDefault();
        TimeZone timeZone2 = TimeZone.getTimeZone("Asia/Jakarta");

        String[] availableIDs = TimeZone.getAvailableIDs();

        System.out.println(timeZone1);
        System.out.println(timeZone2);
        Arrays.asList(TimeZone.getAvailableIDs()).forEach(System.out::println);
    }

    @Test
    void testDate() {

        Date date = new Date();
        System.out.println(date.toString());
        System.out.println(date.toGMTString());
    }

    @Test
    void testModifyTimezoneCalendar() {

        Calendar calendarJakarta = Calendar.getInstance(TimeZone.getTimeZone("Asia/Jakarta"));
        Calendar calendarGMT = Calendar.getInstance(TimeZone.getTimeZone("GMT"));

        System.out.println(calendarJakarta.get(Calendar.HOUR_OF_DAY));
        System.out.println(calendarGMT.get(Calendar.HOUR_OF_DAY));

        calendarJakarta.setTimeZone(TimeZone.getTimeZone("GMT"));
        System.out.println(calendarJakarta.get(Calendar.HOUR_OF_DAY));

    }
}
