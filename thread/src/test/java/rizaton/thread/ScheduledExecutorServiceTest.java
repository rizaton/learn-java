package rizaton.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

public class ScheduledExecutorServiceTest {

    @Test
    void delayedJob() {
        try (ScheduledExecutorService executor = Executors.newScheduledThreadPool(10)) {
            ScheduledFuture<?> future =  executor.schedule(() -> System.out.println("Hello World"), 5, TimeUnit.SECONDS);
            System.out.println(future.getDelay(TimeUnit.MILLISECONDS));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    void periodicJob() {
        try (ScheduledExecutorService executor = Executors.newScheduledThreadPool(10)) {
            ScheduledFuture<?> future =  executor.scheduleAtFixedRate(() -> System.out.println("Hello World"), 2, 2, TimeUnit.SECONDS);
            System.out.println(future.getDelay(TimeUnit.MILLISECONDS));
            boolean timeout = executor.awaitTermination(5, TimeUnit.DAYS);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
