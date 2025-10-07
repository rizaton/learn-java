package rizaton.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import rizaton.test.generator.RandomParameterResolver;

import java.util.Random;

@Extensions(value = {
        @ExtendWith(RandomParameterResolver.class)
})
public class RandomCalculatorTest extends ParentCalculatorTest{

    private final Calculator calculator = new Calculator();

    @Test
    public void testRandom(Random random) {
        var a = random.nextInt();
        var b = random.nextInt();
        System.out.println(a);
        System.out.println(b);
        System.out.println(calculator.add(a, b));
        Assertions.assertEquals(a + b, calculator.add(a, b));
    }

}
