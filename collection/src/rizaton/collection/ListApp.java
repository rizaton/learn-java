package rizaton.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListApp {
    public static void main(String[] args) {

        List<String> names = new ArrayList<>(10);
//        List<String> names = new LinkedList<>();

        names.add("John");
        names.add("Jane");
        names.add("Julie");
        names.add("Peter");
        names.add("Hanks");
        System.out.println(names);

        names.set(1, "Richard");
        System.out.println(names);

        names.remove(3);
        System.out.println(names);

    }
}
