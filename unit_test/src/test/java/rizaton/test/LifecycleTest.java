package rizaton.test;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

public class LifecycleTest {

    private String temp;

    @Test
    void testA(){
        temp = "Iza";
    }

    @Test
    void testB(){
        System.out.println(temp);
    }
}
