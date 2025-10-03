package rizaton.lambda.app;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

public class OptionalApp {
    public static void main(String[] args) {
        sayHello("Iza");

        String name = null;
        sayHello(name);
    }
    public static void sayHello(String name){
//        Optional.ofNullable(name)
//                .map(String::toUpperCase)
//                .ifPresentOrElse(
//                        value -> System.out.println("HELLO " + value),
//                        () -> System.out.println("HELLO")
//                );

        String upperName = Optional.ofNullable(name)
                .map(String::toUpperCase)
                .orElse("FRIEND");

        System.out.println("HELLO " + upperName);


//        Optional<String> optionalName = Optional.ofNullable(name);
//        Optional<String> optionalNameUpper = optionalName.map(String::toUpperCase);
//        optionalNameUpper.ifPresent(nameUpper -> System.out.println("HELLO " + nameUpper));

        // if check null
//        if (name != null){
//            String upperName = name.toUpperCase();
//            System.out.println("HELLO " + upperName);
//        }

    }
}
