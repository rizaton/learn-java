package rizaton.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ForEachOperationTest {
    @Test
    void testPeek() {
        List<String> names = List.of("Jane", "Jack",  "Julia", "Marianne", "John", "June", "Robert", "Gracia", "Zayne", "Hanks");
        names.stream()
                .peek(name -> System.out.println("Name before UPPER : " + name))
                .map(String::toUpperCase)
                .peek(name -> System.out.println("Name after UPPER : " + name))
                .forEach(System.out::println);

    }
}
