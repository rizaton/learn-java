package rizaton.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

public class StreamPipelineTest {

    @Test
    void testCreateStreamPipeline() {
        // Not really usable
        List<String> list = List.of("John", "Mary", "Robert", "Jane");
        Stream<String> stream = list.stream();
        Stream<String> streamUpper = stream.map(String::toUpperCase);
        Stream<String> streamMr = streamUpper.map(upper -> "Mr/s. " + upper);
        streamMr.forEach(System.out::println);
    }

    @Test
    void testStreamPipeline() {
        List<String> list = List.of("John", "Mary", "Robert", "Jane");
        list.stream()
                .map(String::toUpperCase)
                .map(upper ->"Mr/s. " + upper)
                .forEach(System.out::println);
    }
}
