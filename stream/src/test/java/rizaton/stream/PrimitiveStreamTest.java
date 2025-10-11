package rizaton.stream;

import org.junit.jupiter.api.Test;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStreamTest {
    @Test
    void testCreate() {
        IntStream intStream =  IntStream.range(1, 5);
        intStream.forEach(System.out::println);

        LongStream longStream =  LongStream.of(1, 2, 3, 4);

        DoubleStream doubleStream = DoubleStream.builder().add(0.1).add(0.5).build();
    }

    @Test
    void testOperations() {
        IntStream intStream =  IntStream.range(1, 5);

        OptionalDouble optionalDouble = intStream.average();
        System.out.println(optionalDouble);

        IntStream intStream1 =  IntStream.range(1, 100);
        intStream1.mapToObj(number -> "Number : " + number).forEach(System.out::println);

    }
}
