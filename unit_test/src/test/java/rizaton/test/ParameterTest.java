package rizaton.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

public class ParameterTest extends ParentCalculatorTest{

    @DisplayName("Test Calculator with Parameter")
    @ParameterizedTest(name = "{displayName} with data {0}")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void testWithParameter(int value){
        var result = value + value;
        Assertions.assertEquals(result, calculator.add(value,value));
    }

    public static List<Integer> parameterSource() {
        return List.of(1, 2,  3, 4, 5);
    }

    @ParameterizedTest
    @MethodSource(value = {"parameterSource"})
    public void testWithMethodSource(Integer value) {
        var result = value + value;
        Assertions.assertEquals(result, calculator.add(value,value));
    }

}
