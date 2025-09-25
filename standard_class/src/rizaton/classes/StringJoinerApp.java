package rizaton.classes;

import java.util.StringJoiner;

public class StringJoinerApp {
    public static void main(String[] args) {

        StringJoiner joiner = new StringJoiner(", ", "{", "}");

        joiner.add("Iza");
        joiner.add("Riza");
        joiner.add("Rizaton");

        String value = joiner.toString();
        System.out.println(value);
    }
}
