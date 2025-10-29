package rizaton.datetime;

import org.junit.jupiter.api.Test;

import java.time.*;

public class OffsetTimeTest {

    @Test
    void testCreate() {
        OffsetTime offsetTime1 = OffsetTime.now();
        OffsetTime offsetTime2 = OffsetTime.of(LocalTime.now(), ZoneOffset.ofHours(7));
        OffsetTime offsetTime3 = OffsetTime.of(10, 10, 10, 10, ZoneOffset.ofHours(7));
        OffsetTime offsetTime4 = OffsetTime.parse("04:24:28.444280900+07:00");
        OffsetTime offsetTime5 = OffsetTime.now(ZoneId.of("Asia/Jakarta"));

        System.out.println(offsetTime1);
        System.out.println(offsetTime2);
        System.out.println(offsetTime3);
        System.out.println(offsetTime4);
        System.out.println(offsetTime5);

        OffsetDateTime offsetDateTime1 = OffsetDateTime.now();
        OffsetDateTime offsetDateTime2 = OffsetDateTime.now(ZoneId.of("Asia/Jakarta"));
        OffsetDateTime offsetDateTime3 = OffsetDateTime.of(LocalDateTime.now(), ZoneOffset.ofHours(7));
        OffsetDateTime offsetDateTime4 = OffsetDateTime.parse("1980-09-17T10:10:10.100000000+05:00");

        System.out.println(offsetDateTime1);
        System.out.println(offsetDateTime2);
        System.out.println(offsetDateTime3);
        System.out.println(offsetDateTime4);

    }

    @Test
    void testConversionLocalTime() {
        LocalTime localtime = LocalTime.now();
        System.out.println(localtime);
        OffsetTime offsetTime = localtime.atOffset(ZoneOffset.ofHours(7));
        System.out.println(offsetTime);

        LocalTime localtime1 = offsetTime.toLocalTime();
        System.out.println(localtime1);

    }

    @Test
    void testConversionLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.ofHours(7));
        System.out.println(offsetDateTime);

        LocalDateTime localDateTime1 = offsetDateTime.toLocalDateTime();
        System.out.println(localDateTime1);
    }
}
