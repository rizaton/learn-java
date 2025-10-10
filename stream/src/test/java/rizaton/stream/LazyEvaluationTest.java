package rizaton.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class LazyEvaluationTest {
    @Test
    void testIntermediateOperation() {
        List<String> names = List.of("Jane", "John", "Mary");
        Stream<String> stream = names.stream()
                .map(name -> {
                    System.out.println("Changing " + name + " to UPPERCASE");
                    return name.toUpperCase();
                });
    }
    @Test
    void testTerminalOperation() {
        List<String> names = List.of("Jane", "John", "Mary");
        names.stream()
                .map(name -> {
                    System.out.println("Changing " + name + " to UPPERCASE");
                    return name.toUpperCase();
                })
                .map(upper -> {
                    System.out.println("Changing " + upper + " to Mr/s. ");
                    return "Mr/s. " + upper;
                })
                .forEach(System.out::println);
    }
}
