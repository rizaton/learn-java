package rizaton.datetime;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class ZonedDateTimeTest {

    @Test
    void testCreateZonedDateTime() {
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
        ZonedDateTime zonedDateTime2 = ZonedDateTime.now(ZoneId.of("GMT"));
        ZonedDateTime zonedDateTime3 = ZonedDateTime.of(LocalDateTime.now(), ZoneOffset.ofHours(7));
        ZonedDateTime zonedDateTime4 = ZonedDateTime.of(LocalDateTime.now(), ZoneId.of("Asia/Jakarta"));

        System.out.println(zonedDateTime1);
        System.out.println(zonedDateTime2);
        System.out.println(zonedDateTime3);
        System.out.println(zonedDateTime4);
    }

    @Test
    void testParsingZonedDateTime() {
        ZonedDateTime zonedDateTime1 = ZonedDateTime.parse("2025-10-30T03:20:14.534355900+07:00[Asia/Jakarta]");
        ZonedDateTime zonedDateTime2 = ZonedDateTime.parse("2025-10-30T03:20:14.535354000+07:00");

        System.out.println(zonedDateTime1);
        System.out.println(zonedDateTime2);
    }

    @Test
    void testChangeZoneIdZonedDateTime() {
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
        System.out.println(zonedDateTime1);

        ZonedDateTime zonedDateTime2 = zonedDateTime1.withZoneSameLocal(ZoneId.of("GMT"));
        ZonedDateTime zonedDateTime3 = zonedDateTime1.withZoneSameInstant(ZoneId.of("GMT"));

        System.out.println(zonedDateTime2);
        System.out.println(zonedDateTime3);
    }

    @Test
    void testModifyZonedDateTime() {
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
        ZonedDateTime zonedDateTime2 = zonedDateTime1.plusHours(10);
        ZonedDateTime zonedDateTime3 = zonedDateTime2.minusHours(17).minusMinutes(50);
        ZonedDateTime zonedDateTime4 = zonedDateTime3
                .plusHours(3)
                .plusMinutes(30)
                .plusSeconds(45)
                .plusNanos(900_000_123);

        System.out.println(zonedDateTime1);
        System.out.println(zonedDateTime2);
        System.out.println(zonedDateTime3);
        System.out.println(zonedDateTime4);
    }
}
