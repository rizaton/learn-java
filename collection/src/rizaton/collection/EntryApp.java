package rizaton.collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EntryApp {
    public static void main(String[] args) {

        Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("three", 3);
        map.put("two", 2);

        Set<Map.Entry<String, Integer>> entries = map.entrySet();

        for (var entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}

