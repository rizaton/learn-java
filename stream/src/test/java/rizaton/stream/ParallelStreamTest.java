package rizaton.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class ParallelStreamTest {
    @Test
    void testSequential() {
        List<Integer> numbers =  List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> streamNumbers = numbers.stream();
        streamNumbers.forEach(number -> System.out.println(Thread.currentThread().getName() + " : " + number));

    }
    @Test
    void testParallel() {
        List<Integer> numbers =  List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> streamNumbers = numbers.stream().parallel();
        streamNumbers.forEach(number -> System.out.println(Thread.currentThread().getName() + " : " + number));

    }
}
