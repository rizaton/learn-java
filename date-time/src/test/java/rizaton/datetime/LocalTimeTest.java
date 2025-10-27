package rizaton.datetime;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

public class LocalTimeTest {

    @Test
    void testLocalTimeCreate() {
        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = LocalTime.of(1,2,3,4);
        LocalTime localTime2 = LocalTime.parse("12:34:56.408473600");

        System.out.println(localTime);
        System.out.println(localTime1);
        System.out.println(localTime2);
    }

    @Test
    void testLocalTimeWith() {
        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = localTime.with(LocalTime.of(1,2,3,4));
        LocalTime localTime2 = localTime1.withHour(11).withMinute(59).withSecond(59).withNano(199_999_999);

        System.out.println(localTime);
        System.out.println(localTime1);
        System.out.println(localTime2);
    }

    @Test
    void testLocalTimeManipulate() {
        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = localTime.with(LocalTime.of(1,2,3,4)).plusHours(5).plusNanos(323_232_323);
        LocalTime localTime2 = localTime1.withHour(11).withMinute(59).withSecond(59).withNano(199_999_999).minusNanos(100_000_000);

        System.out.println(localTime);
        System.out.println(localTime1);
        System.out.println(localTime2);
    }

    @Test
    void testLocalTimeGet() {
        LocalTime localTime = LocalTime.now();
        LocalTime localTime1 = localTime.with(LocalTime.of(1,2,3,4)).plusHours(5).plusNanos(323_232_323);
        LocalTime localTime2 = localTime1.withHour(11).withMinute(59).withSecond(59).withNano(199_999_999).minusNanos(100_000_000);

        System.out.println(localTime.getHour());
        System.out.println(localTime1.getSecond());
        System.out.println(localTime2.getNano());
    }
}
