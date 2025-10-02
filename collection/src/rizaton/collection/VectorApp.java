package rizaton.collection;

import java.util.List;
import java.util.Vector;

public class VectorApp {
    public static void main(String[] args) {

        List<String> list = new Vector<>();

        list.add("John");
        list.add("Jane");
        list.add("Julie");

        for (var value : list){
            System.out.println(value);
        }

    }
}
