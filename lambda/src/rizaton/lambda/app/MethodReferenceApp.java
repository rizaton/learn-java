package rizaton.lambda.app;

import rizaton.lambda.util.StringUtil;

import java.util.function.Function;
import java.util.function.Predicate;

public class MethodReferenceApp {
    public static void main(String[] args) {

//        Predicate<String> predicateIsLowerCase = s -> StringUtil.isLowerCase(s);
        Predicate<String> predicateIsLowerCase = StringUtil::isLowerCase;

        System.out.println(predicateIsLowerCase.test("Hello"));
        System.out.println(predicateIsLowerCase.test("hello"));

        new MethodReferenceApp().running();
        new MethodReferenceApp().running2();

        // Method Reference Parameter

//        Function<String, String> functionUpper = s -> s.toUpperCase();
        Function<String, String> functionUpper = String::toUpperCase;

        System.out.println(functionUpper.apply("Hello"));

    }

    public void running() {
        Predicate<String> predicateIsLowerCase = this::isLowerCase;

        System.out.println(predicateIsLowerCase.test("Hello"));
        System.out.println(predicateIsLowerCase.test("hello"));
    }

    public void running2() {
        MethodReferenceApp obj = new MethodReferenceApp();
        Predicate<String> predicateIsLowerCase = obj::isLowerCase;

        System.out.println(predicateIsLowerCase.test("Hello"));
        System.out.println(predicateIsLowerCase.test("hello"));
    }

    public boolean isLowerCase(String value) {
        for (var c : value.toCharArray()) {
            if (!Character.isLowerCase(c)) {
                return false;
            }
        }
        return true;
    }
}
