package rizaton.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsTest {

    Stream<String> getStream() {
        return Stream.of("Jane", "Jack",  "Julia", "Marianne", "John", "June", "Robert", "Gracia", "Zayne", "Hanks");
    }

    @Test
    void testCollection() {
        Set<String> set = getStream().collect(Collectors.toSet());
        Set<String> immutableSet = getStream().collect(Collectors.toUnmodifiableSet());

        List<String> list = getStream().collect(Collectors.toList());
        List<String> immutableList = getStream().collect(Collectors.toUnmodifiableList());

    }

    @Test
    void testCollectorsMap() {
        Map<String, String> names = getStream().collect(Collectors.toMap(
           name -> name,
           name -> String.valueOf(name.length())
        ));
        System.out.println(names);
    }
}
