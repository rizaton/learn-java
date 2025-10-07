package rizaton.test;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import rizaton.test.generator.RandomParameterResolver;

import java.util.Random;

@Extensions(value = {
        @ExtendWith(RandomParameterResolver.class)
})
public class RandomCalculatorTest extends ParentCalculatorTest{

    private final Calculator calculator = new Calculator();

    @DisplayName("Test Calculator Random")
    @RepeatedTest(
            value = 3,
            name = "{displayName} no.{currentRepetition} out of {totalRepetitions}"
    )
    public void testRandom(Random random, TestInfo testInfo, RepetitionInfo repetitionInfo) {
        System.out.println(testInfo.getDisplayName() + " no." + repetitionInfo.getCurrentRepetition() + " out of " + repetitionInfo.getTotalRepetitions() );
        var a = random.nextInt();
        var b = random.nextInt();
        Assertions.assertEquals(a + b, calculator.add(a, b));
    }

}
