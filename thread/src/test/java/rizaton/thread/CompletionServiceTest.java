package rizaton.thread;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.*;

public class CompletionServiceTest {

    private final Random random = new Random();

    @Test
    void createCompletionService() {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        ExecutorCompletionService<String> completionService = new ExecutorCompletionService<>(executorService);

        // submit
        ExecutorService executor1 = Executors.newSingleThreadExecutor();
        executor1.execute(() -> {
            for (int i = 0; i < 100; i++) {
                final var index = i;
                completionService.submit(() -> {
                    Thread.sleep(random.nextInt(2000));
                    return "Task-" + index;
                });
            }
        });

        ExecutorService executor2 = Executors.newSingleThreadExecutor();
        executor2.execute(() -> {
            while (true) {
                try {
                    Future<String> future = completionService.poll(5, TimeUnit.SECONDS);
                    if (future == null) {
                        break;
                    } else {
                        System.out.println(future.get());
                    }
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                    break;
                }
            }
        });


        executor2.close();
        executor1.close();
        executorService.close();
    }
}
