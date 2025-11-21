package rizaton.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {

    @Test
    void create() {
        final CountDownLatch latch = new CountDownLatch(5);
        final ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> {
                try {
                    System.out.println("Start Task");
                    Thread.sleep(2_000);
                    System.out.println("Finished Task");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }
        executorService.execute(() -> {
            try {
                latch.await();
                System.out.println("All task Finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.close();

    }
}
