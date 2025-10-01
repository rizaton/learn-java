package rizaton.collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ImmutableSetApp {
    public static void main(String[] args) {

        Set<String> emptySet = Collections.emptySet();
        Set<String> one = Collections.singleton("Peter");

        Set<String> mutable = new HashSet<>();
        mutable.add("John");
        mutable.add("Jane");
        mutable.add("Julie");
        mutable.add("Prince");

        Set<String> immutable = Collections.unmodifiableSet(mutable);

        Set<String> set = Set.of("Peter", "Jane", "Julie");

//        set.remove("Peter"); ERROR
//        set.add("O"); ERROR

    }
}
