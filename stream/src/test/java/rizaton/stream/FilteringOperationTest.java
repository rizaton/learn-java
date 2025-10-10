package rizaton.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

public class FilteringOperationTest {
    @Test
    void testFilter() {
        List<String> names = List.of("Jane", "Julia", "Marianne", "John", "June", "Robert", "Gracia", "Zayne", "Hanks");
        names.stream()
                .filter(name -> name.length() > 4)
                .forEach(System.out::println);

        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(System.out::println);
    }

    @Test
    void testDistinct() {
        List<String> names = List.of("Jane", "John", "June", "Robert", "Gracia", "Zayne", "Hanks", "Julia", "Marianne", "John", "June", "Robert", "Gracia", "Zayne", "Hanks");
        names.stream()
                .distinct()
                .forEach(System.out::println);
    }
}
