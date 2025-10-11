package rizaton.stream;

import org.junit.jupiter.api.Test;

import java.util.List;

public class CheckOperationTest {
    @Test
    void testAnyMatch() {
        List<String> names = List.of("Jane", "Jack",  "Julia", "Marianne", "John", "June", "Robert", "Gracia", "Zayne", "Hanks");
        boolean anyMatch = names.stream()
                .anyMatch(name -> name.length() >= 5);
        System.out.println(anyMatch);
    }

    @Test
    void allMatch() {
        List<String> names = List.of("Jane", "Jack",  "Julia", "Marianne", "John", "June", "Robert", "Gracia", "Zayne", "Hanks");
        boolean  allMatch = names.stream()
                .allMatch(name -> name.length() >= 3); // All must be match
        System.out.println(allMatch);
    }

    @Test
    void testNoneMatch() {
        List<String> names = List.of("Jane", "Jack",  "Julia", "Marianne", "John", "June", "Robert", "Gracia", "Zayne", "Hanks");
        boolean  noneMatch = names.stream()
                .noneMatch(name -> name.length() < 3); // All must be match
        System.out.println(noneMatch);
    }
}
