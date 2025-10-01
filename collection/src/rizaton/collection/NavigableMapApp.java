package rizaton.collection;

import java.util.Collections;
import java.util.NavigableMap;
import java.util.TreeMap;

public class NavigableMapApp {
    public static void main(String[] args) {

        NavigableMap<String, String> map = new TreeMap<>();

        map.put("Jane","Jane");
        map.put("John","John");
        map.put("July","July");

        for (var key : map.keySet()) {
            System.out.println(key);
        }

        System.out.println(map.lowerKey("July"));
        System.out.println(map.higherKey("July"));
        System.out.println(map.floorKey("July"));
        System.out.println(map.ceilingKey("July"));

        NavigableMap<String, String> mapDesc = map.descendingMap();

        for (var key : mapDesc.keySet()) {
            System.out.println(key);
        }

        NavigableMap<String, String> empty = Collections.emptyNavigableMap();
        NavigableMap<String, String> immutable = Collections.unmodifiableNavigableMap(mapDesc);

//        immutable.put("Hello", "Hello"); ERROR

    }
}
