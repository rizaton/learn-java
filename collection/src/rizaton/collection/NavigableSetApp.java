package rizaton.collection;

import java.util.Collections;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class NavigableSetApp {
    public static void main(String[] args) {

        NavigableSet<String> names = new TreeSet<>();
        names.add("Jane");
        names.add("Julie");
        names.add("Robert");

        names.addAll(Set.of("John", "Prince"));

        NavigableSet<String> nameReverse = names.descendingSet();

        NavigableSet<String> julie = names.headSet("Julie", true);
        NavigableSet<String> julieTail = names.tailSet("Julie", true);

        for (var name : julieTail){
            System.out.println(name);
        }

        NavigableSet<String> immutable = Collections.unmodifiableNavigableSet(names);

//        immutable.add("Andy"); ERROR
//        immutable.remove("Julie"); ERROR

    }
}
