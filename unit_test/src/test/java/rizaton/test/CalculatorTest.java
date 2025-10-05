package rizaton.test;

import org.junit.jupiter.api.*;
import org.opentest4j.TestAbortedException;
import rizaton.test.generator.SimpleDisplayNameGenerator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

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

    @Test
    public void testAborted(){
        var profile = System.getenv("PROFILE");
        if (!"DEV".equals(profile)) {
            throw new TestAbortedException("Test Aborted because Profile isn't DEV");
        }
        // unit test for dev
    }

    @Test
    public void testAssumptions(){
        assumeTrue("DEV".equals(System.getenv("PROFILE")));

        // Unit test for DEV
    }

}
