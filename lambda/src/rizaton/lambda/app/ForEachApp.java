package rizaton.lambda.app;

import java.util.List;
import java.util.function.Consumer;

public class ForEachApp {
    public static void main(String[] args) {

        List<String> names = List.of("John", "Jane", "Julie", "Jack", "Jolie", "Johan", "Jen");

        // for loop
        System.out.println("ForLoop");
        for (String name : names) {
            System.out.println(name);
        }
        // for each consume
        System.out.println("Foreach consume");
        names.forEach(new  Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.println(name);
            }
        });

        // lambda
        System.out.println("Foreach lambda");
        names.forEach(name -> System.out.println(name));

        // lambda method reference
        System.out.println("Foreach lambda method reference");
        names.forEach(System.out::println);

    }
}
