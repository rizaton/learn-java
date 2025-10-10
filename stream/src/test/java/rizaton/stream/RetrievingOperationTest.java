package rizaton.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

public class RetrievingOperationTest {
    @Test
    void testLimit() {
        List<String> names = List.of("Jane", "Julia", "Marianne", "John", "June", "Robert", "Gracia", "Zayne", "Hanks");
        names.stream()
                .limit(3)
                .forEach(System.out::println);

    }

    @Test
    void testSkip() {
        List<String> names = List.of("Jane", "Julia", "Marianne", "John", "June", "Robert", "Gracia", "Zayne", "Hanks");
        names.stream()
                .skip(3)
                .forEach(System.out::println);
    }

    @Test
    void testTakeWhile() {
        List<String> names = List.of("Jane", "Jack",  "Julia", "Marianne", "John", "June", "Robert", "Gracia", "Zayne", "Hanks");
        names.stream()
                .takeWhile(name -> name.length() <= 4) // take while, when false, the stream done
                .forEach(System.out::println);
    }

    @Test
    void testDropWhile() {
        List<String> names = List.of("Jane", "Jack",  "Julia", "Marianne", "John", "June", "Robert", "Gracia", "Zayne", "Hanks");
        names.stream()
                .dropWhile(name -> name.length() <= 4)
                .forEach(System.out::println);
    }

    @Test
    void testFindAny() {
        List<String> names = List.of("Jane", "Jack",  "Julia", "Marianne", "John", "June", "Robert", "Gracia", "Zayne", "Hanks");
        Optional<String> optional = names.stream().findAny();

        optional.ifPresent(System.out::println);

    }

    @Test
    void testFindFirst() {
        List<String> names = List.of("Jane", "Jack",  "Julia", "Marianne", "John", "June", "Robert", "Gracia", "Zayne", "Hanks");
        Optional<String> optional = names.stream().findFirst();

        optional.ifPresent(System.out::println);
    }
}
