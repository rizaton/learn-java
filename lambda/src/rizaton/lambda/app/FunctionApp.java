package rizaton.lambda.app;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionApp {
    public static void main(String[] args) {

        Function<String, Integer> funLength = s -> s.length();
        System.out.println(funLength.apply("Hello"));

        BiFunction<String, String, Boolean> biCompare = (String s1, String s2) -> s1.equals(s2);
        System.out.println(biCompare.apply("Hello", "World"));


    }
}
