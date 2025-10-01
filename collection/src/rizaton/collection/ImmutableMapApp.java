package rizaton.collection;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ImmutableMapApp {
    public static void main(String[] args) {

        Map<String, String> empty = Collections.emptyMap();
        Map<String, String> singleton =  Collections.singletonMap("key", "value");

        Map<String, String> mutable = new HashMap<>();
        mutable.put("key", "value");

        Map<String, String> immutable = Collections.unmodifiableMap(mutable);

        Map<String, String> map = Map.of(
                "first", "Jane",
                "middle", "Doe",
                "last", "Alecia"
        );
//        map.put("a", "Alecia"); ERROR
    }
}
