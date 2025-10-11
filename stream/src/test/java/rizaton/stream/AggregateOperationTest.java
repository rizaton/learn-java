package rizaton.stream;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class AggregateOperationTest {
    @Test
    void testMax() {
        List<String> names = List.of("Jane", "Jack",  "Julia", "Marianne", "John", "June", "Robert", "Gracia", "Zayne", "Hanks");
        names.stream()
                .max(Comparator.naturalOrder())
                .ifPresent(System.out::println);
    }
    @Test
    void testMin() {
        List<String> names = List.of("Jane", "Jack",  "Julia", "Marianne", "John", "June", "Robert", "Gracia", "Zayne", "Hanks");
        names.stream()
                .min(Comparator.naturalOrder())
                .ifPresent(System.out::println);
    }
    @Test
    void testCount() {
        List<String> names = List.of("Jane", "Jack",  "Julia", "Marianne", "John", "June", "Robert", "Gracia", "Zayne", "Hanks");
        long counts = names.stream()
                .count();
//                .size();

        System.out.println(counts);
    }

    @Test
    void testSum() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Integer sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);
    }

    @Test
    void testFactorial() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        Integer factorial = numbers.stream().reduce(1, (value, item) -> value * item);
        System.out.println(factorial);
    }

}
