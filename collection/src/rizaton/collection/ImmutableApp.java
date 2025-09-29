package rizaton.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ImmutableApp {
    public static void main(String[] args) {

        List<String> one = Collections.singletonList("One");
        List<String> empty = Collections.emptyList();

        List<String> mutable = new ArrayList<>();
        mutable.add("One");
        mutable.add("Two");
        List<String> immutable = Collections.unmodifiableList(mutable);

        List<String> elements = List.of("One", "Two");
//        elements.add("Three");



    }
}
