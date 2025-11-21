package rizaton.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest

{
    @Test
    void create() {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
        final ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 4; i++) {
            executorService.execute(() -> {
                try {
                    System.out.println("Waiting " + Thread.currentThread().getName());
                    cyclicBarrier.await();
                    System.out.println("Done Waiting " + Thread.currentThread().getName());
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }

        executorService.close();
    }
}
