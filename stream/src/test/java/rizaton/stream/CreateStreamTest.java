package rizaton.stream;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreamTest {

    @Test
    void testCreateEmptyOrSingleStream() {

        Stream<String> emptyStream = Stream.empty();

        Stream<String> oneStream = Stream.of("Hello");

        String data = null;
        Stream<String> emptyOrNotStream = Stream.ofNullable(data);
    }

    @Test
    void testCreateStreamFromArray() {
        Stream<String> streamString = Stream.of("Hello", "World", "!");

        Stream<Integer> streamInteger = Stream.of(1, 2, 3);

        Stream<String> streamArray = Arrays.stream(
            new String[]{
                    "Hello", "World", "!"
            }
        );

        streamString.forEach(System.out::println);
        streamInteger.forEach(System.out::println);


    }

    @Test
    void testCreateStreamFromCollection() {
        Collection<String> collectionString = List.of("Hello", "World", "!");

        Stream<String> streamString = collectionString.stream();

        streamString.forEach(System.out::println);
    }

    @Test
    void testCreateInfiniteStream() {
       Stream<String> stream = Stream.generate(() -> "Hello");
//       stream.forEach(System.out::println);

        Stream<Integer> iterate = Stream.iterate(1, value -> value + 1);
//        iterate.forEach(System.out::println);

        

    }
}
