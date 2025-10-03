package rizaton.lambda.app;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class MapForEachApp {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        map.put("first.name", "John");
        map.put("middle.name", "Doe");
        map.put("last.name", "Smith");

        // for loop
        for (var entry : map.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        // for each anonymous class
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String s, String s2) {
                System.out.println(s + " : " + s2);
            }
        });

        // lambda
        map.forEach((s, s2) -> System.out.println(s + " : " + s2));

    }
}
