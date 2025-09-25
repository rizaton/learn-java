package coding.rizaton.application;

import coding.rizaton.data.*;
import java.lang.*;

public class Application {
    public static void main(String[] args) {
        Product product = new Product("Windows Pro", 500);

        System.out.println(product.name);
        System.out.println(product.price);

        Data data = new Data("k1", "Hello World!");
    }
}
