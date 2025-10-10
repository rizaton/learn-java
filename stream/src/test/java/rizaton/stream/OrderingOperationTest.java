package rizaton.stream;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrderingOperationTest {
    @Test
    void testSorted() {
        List<String> names = List.of("Jane", "Jack",  "Julia", "Marianne", "John", "June", "Robert", "Gracia", "Zayne", "Hanks");
        names.stream()
                .sorted()
                .forEach(System.out::println);
    }

    @Test
    void testSortedWithComparator() {
        Comparator<String> reversed = Collections.reverseOrder() ;
        List<String> names = List.of("Jane", "Jack",  "Julia", "Marianne", "John", "June", "Robert", "Gracia", "Zayne", "Hanks");

        names.stream()
                .sorted(reversed)
                .forEach(System.out::println);
    }
}
