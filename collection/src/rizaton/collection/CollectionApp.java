package rizaton.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionApp {
    public static void main(String[] args) {

        Collection<String> collection = new ArrayList<>();
        collection.add("Iza");
        collection.add("Riza");
        collection.add("John");
        collection.addAll(List.of("Julian","Steve"));
        collection.addAll(Arrays.asList("Jane", "Mary", "Alex"));

        for (String name : collection) {
            System.out.println(name);
        }

        System.out.println("Remove 1 Data");
        boolean removed = collection.remove("John");
        for (String name : collection) {
            System.out.println(name);
        }

        System.out.println("Remove All ListOf");
        collection.removeAll(List.of("Julian","Steve"));
        for (String name : collection) {
            System.out.println(name);
        }

        System.out.println("Remove All ArrayList");
        collection.removeAll(Arrays.asList("Mary","Alex"));
        for (String name : collection) {
            System.out.println(name);
        }

        System.out.println("Remove All retain");
        collection.retainAll(List.of("Iza","Riza"));
        for (String name : collection) {
            System.out.println(name);
        }

        System.out.println(
                collection.contains("Iza")
        );
        System.out.println(
                collection.containsAll(List.of("Iza","Riza"))
        );
        System.out.println(collection.size());

    }
}
