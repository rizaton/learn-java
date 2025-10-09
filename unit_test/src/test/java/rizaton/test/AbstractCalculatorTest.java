package rizaton.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import rizaton.test.resolver.RandomParameterResolver;

@Extensions(value = {
        @ExtendWith(RandomParameterResolver.class)
})
public class AbstractCalculatorTest {

    protected Calculator calculator = new Calculator();

    @BeforeEach
    public void setup() {
        System.out.println("Before each");
    }
}
