package rizaton.datetime;

import org.junit.jupiter.api.Test;

import java.time.*;

public class ClockTest {

    @Test
    void testCreate() {
        Clock clockUTC = Clock.systemUTC();
        Clock clockSystem = Clock.systemDefaultZone();
        Clock clockJakarta = Clock.system(ZoneId.of("Asia/Jakarta"));

        System.out.println(clockUTC);
        System.out.println(clockSystem);
        System.out.println(clockJakarta);
    }

    @Test
    void testToInstant() throws InterruptedException {
        Clock clockJakarta = Clock.system(ZoneId.of("Asia/Jakarta"));

        Instant instant1 =  clockJakarta.instant();
        System.out.println(instant1);
        Thread.sleep(1_000_000);

        Instant instant2 = clockJakarta.instant();
        System.out.println(instant2);
        Thread.sleep(1_000_000);

    }

    @Test
    void toDateAPI() {
        Clock clock = Clock.system(ZoneId.of("Asia/Jakarta"));

        Year year = Year.now(clock);
        YearMonth yearMonth = YearMonth.now(clock);
        LocalTime localTime = LocalTime.now(clock);
        LocalDate  date = LocalDate.now(clock);
        LocalDateTime dateTime = LocalDateTime.now(clock);
        ZonedDateTime zonedDateTime = ZonedDateTime.now(clock);
        OffsetDateTime offsetDateTime = OffsetDateTime.now(clock);

        System.out.println(year);
        System.out.println(yearMonth);
        System.out.println(localTime);
        System.out.println(date);
        System.out.println(dateTime);
        System.out.println(zonedDateTime);
        System.out.println(offsetDateTime);

    }
}
