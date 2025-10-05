package rizaton.test;

import org.junit.jupiter.api.*;
import rizaton.test.generator.SimpleDisplayNameGenerator;

import static org.junit.jupiter.api.Assertions.*;

//@DisplayName("Test for Calculator")
@DisplayNameGeneration(SimpleDisplayNameGenerator.class)
public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @BeforeEach
    public void setUp(){
        System.out.println("Before Each");
    }

    @AfterEach
    public void tearDown(){
        System.out.println("After Each");
    }

    @BeforeAll
    public static void beforeAll(){
        System.out.println("Before All");
    }
    @AfterAll
    public static void afterAll(){
        System.out.println("After All");
    }

    @Test
//    @DisplayName("Scenario success test for add method add(Integer, Integer)")
    public void testAddSuccess() {
        var result = calculator.add(10, 10);
        assertEquals(20, result);

    }

    @Test
    public void testDivideSuccess(){
        var result = calculator.divide(100, 10);
        assertEquals(10, result);
    }

    @Test
    public void testDivideFailed(){
        assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(100, 0)
        );
    }

    @Test
    @Disabled
    public void testComingSoon() {
        //
    }

}
