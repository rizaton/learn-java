package rizaton.collection;

import java.util.EnumMap;
import java.util.Map;

public class EnumHashMapApp {
    public static enum Level {
        FREE, STANDARD, PREMIUM, VIP
    }

    public static void main(String[] args) {

        Map<Level, String> map = new EnumMap<Level, String>(Level.class);
        map.put(Level.STANDARD, "Robert");
        map.put(Level.PREMIUM, "Jane");
        map.put(Level.VIP, "Mary");
        map.put(Level.FREE, "John");

        for (var key : map.keySet()) {
            System.out.println(map.get(key));
        }

    }
}
