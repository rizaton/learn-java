package rizaton.datetime;

import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.temporal.*;
import java.util.ArrayList;
import java.util.List;

public class TemporalTest {

    @Test
    void temporal() {
        Temporal temporal1 = LocalDate.now();
        Temporal temporal2 = LocalDateTime.now();
        Temporal temporal3 = LocalTime.now();
        Temporal temporal4 = ZonedDateTime.now();
        Temporal temporal5 = Year.now();
        Temporal temporal6 = OffsetDateTime.now();
        Temporal temporal7 = OffsetTime.now();

        System.out.println(temporal1);
        System.out.println(temporal2);
        System.out.println(temporal3);
        System.out.println(temporal4);
        System.out.println(temporal5);
        System.out.println(temporal6);
        System.out.println(temporal7);

    }

    @Test
    void temporalAmount() {
        Temporal temporal1 = LocalDateTime.now();
        Temporal temporal2 = temporal1.plus(Duration.ofHours(10));
        Temporal temporal3 = temporal1.plus(Period.ofDays(10));

        System.out.println(temporal1);
        System.out.println(temporal2);
        System.out.println(temporal3);
    }

    @Test
    void temporalUnit() {
        long temporalUnit1 = ChronoUnit.MINUTES.between(LocalTime.now(), LocalTime.now().plusHours(10));
        System.out.println(temporalUnit1);
    }

    @Test
    void temporalField() {
        Temporal temporal = LocalDateTime.now();

        int year = temporal.get(ChronoField.YEAR);

        System.out.println(year);
        System.out.println(temporal.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(temporal.get(ChronoField.DAY_OF_MONTH));
        System.out.println(temporal.get(ChronoField.HOUR_OF_DAY));
        System.out.println(temporal.get(ChronoField.HOUR_OF_DAY));
        System.out.println(temporal.get(ChronoField.MINUTE_OF_HOUR));
        System.out.println(temporal.get(ChronoField.SECOND_OF_MINUTE));
        System.out.println(temporal.get(ChronoField.MILLI_OF_SECOND));

    }

    @Test
    void temporalQuery() {
        LocalDateTime localDateTime = LocalDateTime.now();

        List<Integer> integers = localDateTime.query(new TemporalQuery<List<Integer>>() {
            @Override
            public List<Integer> queryFrom(TemporalAccessor temporal) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(temporal.get(ChronoField.YEAR));
                list.add(temporal.get(ChronoField.MONTH_OF_YEAR));
                list.add(temporal.get(ChronoField.DAY_OF_MONTH));
                list.add(temporal.get(ChronoField.HOUR_OF_DAY));
                list.add(temporal.get(ChronoField.MINUTE_OF_HOUR));
                list.add(temporal.get(ChronoField.SECOND_OF_MINUTE));
                list.add(temporal.get(ChronoField.MILLI_OF_SECOND));
                list.add(temporal.get(ChronoField.NANO_OF_SECOND));
                return list;
            }
        });

        integers.forEach(System.out::println);
    }

    @Test
    void temporalAdjuster() {
        Temporal temporal = LocalDate.now();
        System.out.println(temporal);

        Temporal temporal1 = temporal.with(TemporalAdjusters.firstDayOfMonth());
        Temporal temporal2 = temporal.with(TemporalAdjusters.lastDayOfMonth());
        Temporal temporal3 = temporal.with(TemporalAdjusters.firstDayOfYear());
        Temporal temporal4 = temporal.with(TemporalAdjusters.lastDayOfYear());

        System.out.println(temporal);
        System.out.println(temporal1);
        System.out.println(temporal2);
        System.out.println(temporal3);
        System.out.println(temporal4);

        Temporal temporal5 = temporal.with(new TemporalAdjuster() {
            @Override
            public Temporal adjustInto(Temporal temporal) {
                return LocalDate.of(
                        temporal.get(ChronoField.YEAR),
                        temporal.get(ChronoField.MONTH_OF_YEAR),
                        temporal.get(ChronoField.DAY_OF_MONTH)
                );
            }
        });
        System.out.println(temporal5);
    }
}
