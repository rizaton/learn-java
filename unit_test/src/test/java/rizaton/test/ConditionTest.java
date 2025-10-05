package rizaton.test;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

import java.util.Properties;

@Tag("integration-test")
public class ConditionTest {

    @Test
    @Disabled
    void testSystemProperties() {
        Properties properties = System.getProperties();
        properties.forEach((key, value) -> System.out.println(key + ": " + value));
    }

    @Test
    @EnabledOnOs({OS.WINDOWS})
    public void testRunOnlyOnWindows(){
        //
    }

    @Test
    @DisabledOnOs({OS.WINDOWS})
    public void testDisabledOnlyOnWindows(){
        //
    }

    @Test
    @EnabledOnJre({JRE.JAVA_21})
    public void testRunOnlyOnJava21(){
        //
    }

    @Test
    @DisabledOnJre({JRE.JAVA_21})
    public void testDisabledOnlyOnJava21(){
        //
    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_15, max = JRE.JAVA_21)
    public void testEnabledOnJava15to21(){
        //
    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_15, max = JRE.JAVA_21)
    public void testDisabledOnJava15to21(){
        //
    }

    @Test
    @EnabledIfSystemProperties({
            @EnabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    })
    public void testEnableOnOracle(){
        //
    }

    @Test
    @DisabledIfSystemProperty(named = "java.vendor", matches = "Oracle Corporation")
    public void testDisableOnOracle(){
        //
    }

    @Test
    @EnabledIfEnvironmentVariables({
            @EnabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    public void testEnabledOnProfileDev(){
        //
    }

    @Test
    @DisabledIfEnvironmentVariables({
            @DisabledIfEnvironmentVariable(named = "PROFILE", matches = "DEV")
    })
    public void testDisabledOnProfileDev(){
        //
    }

}
