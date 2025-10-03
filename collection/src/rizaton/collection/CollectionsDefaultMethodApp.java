package rizaton.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class CollectionsDefaultMethodApp {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        System.out.println(list);

        list.replaceAll(new UnaryOperator<Integer>() {
            @Override
            public Integer apply(Integer input) {
                return ((((input + 29) * 13) + 7) * 31) >>> 3;
            }
        });

        System.out.println(list);

        list.forEach(new Consumer<Integer>() {
            @Override
            public void accept(Integer input) {
                System.out.println(input);
            }
        });

        list.removeIf(new  Predicate<Integer>() {
            @Override
            public boolean test(Integer input) {
                return input % 2 == 0;
            }
        });

        System.out.println(list);

    }
}
