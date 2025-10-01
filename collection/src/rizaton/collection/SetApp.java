package rizaton.collection;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetApp {
    public static void main(String[] args) {

//        Set<String> names =  new HashSet<String>(); // Non in sequence
        Set<String> names =  new LinkedHashSet<>(); // in sequence
        names.add("John");
        names.add("Jane");
        names.add("Julie");
        names.add("Robert");
//        names.add("John");

        for (String name : names) {
            System.out.println(name);
        }

    }
}
