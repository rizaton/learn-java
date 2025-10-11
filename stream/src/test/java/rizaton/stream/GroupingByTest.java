package rizaton.stream;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupingByTest {
    @Test
    void testGroupingBy() {
        Stream<Integer> numbers =  Stream.of(1, 2, 3, 4, 5);
        Map<String, List<Integer>> collect = numbers.collect(Collectors.groupingBy(number -> {
            if (number > 5) {
                return "Big";
            } else  {
                return "Small";
            }
        }));
        System.out.println(collect);
    }

    @Test
    void testGroupingBy2() {
        Stream<String> names = Stream.of("Jane", "Jack",  "Julia", "Marianne", "John", "June", "Robert", "Gracia", "Zayne", "Hanks");
        Map<String, List<String>> collect = names.collect(Collectors.groupingBy(name -> {
            if (name.length() > 5) {
                return "Long";
            } else   {
                return "Short";
            }
        }));
        System.out.println(collect);
    }

    @Test
    void testPartitioningBy() {
        Stream<Integer> numbers =  Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> collect = numbers
                .collect(Collectors.partitioningBy(number -> {
            return number > 5;
        }));
        System.out.println(collect);
    }

    @Test
    void testPartitioningBy2() {
        Stream<String> names = Stream.of("Jane", "Jack",  "Julia", "Marianne", "John", "June", "Robert", "Gracia", "Zayne", "Hanks");
        Map<Boolean, List<String>> collect = names.collect(Collectors.partitioningBy(name -> {
            return name.length() > 4;
        }));
        System.out.println(collect);
    }
}
