package rizaton.datetime;

import org.junit.jupiter.api.Test;

import java.time.*;

public class InstantTest {

    @Test
    void testCreate() {

        Instant instant1 = Instant.now();
        System.out.println(instant1);

        Instant instant2 = Instant.ofEpochMilli(10000);
        System.out.println(instant2);

        Instant instant3 = Instant.parse("2025-11-01T23:55:39.706244Z");
        System.out.println(instant3);
    }

    @Test
    void testNModify() {
        Instant instant1 = Instant.now();
        Instant instant2 = instant1.plusSeconds(1000);
        Instant instant3 = instant2.plusMillis(10000);

        System.out.println(instant1);
        System.out.println(instant2);
        System.out.println(instant3);
    }

    @Test
    void testGet() {
        Instant instant1 = Instant.now();
        long epochMilli = instant1.toEpochMilli();
        long epochSecond = instant1.getEpochSecond();
        int nano =  instant1.getNano();

        System.out.println(epochMilli);
        System.out.println(epochSecond);
        System.out.println(nano);
    }

    @Test
    void testConversion() {
        Instant instant =  Instant.now();
        ZoneId zoneId = ZoneId.systemDefault();

        LocalTime localTime = LocalTime.ofInstant(instant, zoneId);
        System.out.println(localTime);

        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zoneId);
        System.out.println(localDateTime);

        ZonedDateTime zonedDateTime = ZonedDateTime.ofInstant(instant, zoneId);
        System.out.println(zonedDateTime);

        OffsetDateTime offsetDateTime = OffsetDateTime.ofInstant(instant, zoneId);
        System.out.println(offsetDateTime);
    }

    @Test
    void testToInstant() {
        Instant instant1 = LocalDateTime.now().toInstant(ZoneOffset.ofHours(7));
        System.out.println(instant1);

        Instant instant2 = ZonedDateTime.now().toInstant();
        System.out.println(instant2);

        Instant instant3 = OffsetDateTime.now().toInstant();
        System.out.println(instant3);
    }
}
