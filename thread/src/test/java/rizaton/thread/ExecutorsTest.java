package rizaton.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsTest {

    @Test
    void testExecutorService() {
        try (ExecutorService executorService = Executors.newSingleThreadExecutor()) {
            for (int i = 1; i <= 100; i++) {
                executorService.execute(() -> {
                    try {
                        Thread.sleep(1_000);
                        System.out.println("Runnable in thread : " + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
            var isTerminated = executorService.awaitTermination(1, TimeUnit.DAYS);
            System.out.println(isTerminated);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testExecutorServiceFixed() {
        try (ExecutorService executorService = Executors.newFixedThreadPool(10)) {
            for (int i = 1; i <= 100; i++) {
                executorService.execute(() -> {
                    try {
                        Thread.sleep(1_000);
                        System.out.println("Runnable in thread : " + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
            executorService.shutdown();
        }
    }
}
