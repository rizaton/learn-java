package rizaton.stream;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamOperationsTest {

    @Test
    void testMapStream() {

        List<String> names = List.of("John", "Mary", "Robert", "Jane");

        Stream<String> streamNames = names.stream();
        Stream<String> streamUpper =  streamNames.map(String::toUpperCase);

        streamUpper.forEach(System.out::println);
        names.forEach(System.out::println);
    }
}
