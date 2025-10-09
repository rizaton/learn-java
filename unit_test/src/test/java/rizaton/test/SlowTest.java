package rizaton.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;

import java.util.concurrent.TimeUnit;

@Execution(ExecutionMode.CONCURRENT)
public class SlowTest {

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    public void slowTest1() throws InterruptedException {
        Thread.sleep(4000);
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    public void slowTest2() throws InterruptedException {
        Thread.sleep(4000);
    }

    @Test
    @Timeout(value = 5, unit = TimeUnit.SECONDS)
    public void slowTest3() throws InterruptedException {
        Thread.sleep(4000);
    }

}
