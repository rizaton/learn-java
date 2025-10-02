package rizaton.collection;

import java.util.Hashtable;
import java.util.Map;

public class HashTableApp {
    public static void main(String[] args) {

        Map<String,  String> map = new Hashtable<>();

        map.put("John", "John");
        map.put("Jane", "Jane");
        map.put("Julie", "Julie");

        for(var s : map.keySet()){
            System.out.println(s);
        }

    }
}
