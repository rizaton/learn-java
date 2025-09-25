package rizaton.generic.application;

import rizaton.generic.util.ArrayHelper;

public class ArrayHelperApp {
    public static void main(String[] args) {

        String[] names = {"Iza", "Riza", "John", "Jane"};
        Integer[] numbers = {1, 2, 3, 4, 5};

        System.out.println(
                ArrayHelper.<String>count(names)
        );
        System.out.println(
                ArrayHelper.count(numbers)
        );

    }
}
