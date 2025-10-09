package rizaton.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

public class SlowTest {

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    public void slow() throws InterruptedException {
        Thread.sleep(4000);
    }

}
