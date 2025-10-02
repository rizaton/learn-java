package rizaton.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingApp {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of("Jane", "Adam", "Zane", "Vincent"));
        Collections.sort(list);

        for (var item : list) {
            System.out.println(item);
        }

        Comparator<String> reverse = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        };

        Collections.sort(list, reverse);
        // list.sort(reverse);

        for (var item : list) {
            System.out.println(item);
        }

    }
}
