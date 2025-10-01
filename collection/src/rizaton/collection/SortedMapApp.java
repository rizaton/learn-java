package rizaton.collection;

import java.util.Collections;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapApp {
    public static void main(String[] args) {

        Comparator<String> stringComparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };

        SortedMap<String, String> map =  new TreeMap<>(stringComparator);
        map.put("key2", "value2");
        map.put("key1", "value1");
        map.put("key3", "value3");

        for (String key : map.keySet()) {
            System.out.println(key);
        }

        SortedMap<String, String> empty = Collections.emptySortedMap();
        SortedMap<String, String> immutable = Collections.unmodifiableSortedMap(map);
//        immutable.put("key1", "value1"); ERROR

    }
}
