package rizaton.thread;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrentMapTest {

    @Test
    void concurrentMap() {
        final CountDownLatch countDownLatch = new CountDownLatch(100);

        final ConcurrentMap<Integer, String> map = new ConcurrentHashMap<>();;
        final ExecutorService executor =  Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            final int index = i;
            executor.execute(() -> {
                try {
                    Thread.sleep(1_000);
                    map.putIfAbsent(index, "Data-" + index + " With: " + Thread.currentThread().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        executor.execute(() -> {
            try {
                countDownLatch.await();
                map.forEach((integer, string) -> System.out.println(integer + " : " + string));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        
        executor.close();
    }

    @Test
    void collection() {
        List<String> list = List.of("Iza", "Riza", "John", "Mary");
        List<String> synchronizedList = Collections.synchronizedList(list);
        
    }
}
