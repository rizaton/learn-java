package rizaton.lambda.app;

import java.util.function.Supplier;

public class SupplierApp {
    public static void main(String[] args) {

        Supplier<String> supplier = () -> "Hello";

        String hello = supplier.get();
        System.out.println(hello);

    }
}
