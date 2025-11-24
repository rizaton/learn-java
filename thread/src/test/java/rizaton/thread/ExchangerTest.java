package rizaton.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {

    @Test
    void exchanger() {

        final Exchanger<String> exchanger = new Exchanger<>();
        final ExecutorService executor = Executors.newFixedThreadPool(10);

        executor.execute(() -> {
            try {
                System.out.println("Thread 1: Send: First");
                Thread.sleep(1_000);
                String result = exchanger.exchange("First");
                System.out.println("Thread 1: Receive: " + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.execute(() -> {
            try {
                System.out.println("Thread 2: Send: Second");
                Thread.sleep(2_000);
                String result = exchanger.exchange("Second");
                System.out.println("Thread 2: Receive: " + result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executor.close();
    }
}
