package rizaton.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    @Test
    void createThreadPool() {
        var minThread = 10;
        var maxThread = 100;
        var alive = 1;
        var aliveTime = TimeUnit.MINUTES;

        var queue = new ArrayBlockingQueue<Runnable>(100);

        Runnable runnable = () -> {
            try {
                Thread.sleep(5_000);
                System.out.println("Runnable from thread : " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        try (var executor = new ThreadPoolExecutor(minThread, maxThread, alive, aliveTime, queue)){
            executor.execute(runnable);
            Thread.sleep(7_000);
        } catch (RuntimeException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void threadPoolShutdown() {
        var minThread = 10;
        var maxThread = 100;
        var alive = 1;
        var aliveTime = TimeUnit.MINUTES;

        var queue = new ArrayBlockingQueue<Runnable>(1000);

        try (var executor = new ThreadPoolExecutor(minThread, maxThread, alive, aliveTime, queue)){
            for (int i = 0; i < 1000; i++) {
                final var task = i;
                executor.execute(() -> {
                    try {
                        Thread.sleep(1_000);
                        System.out.println("Task " + task + " from thread : " + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }

            Thread.sleep(7_000);
            executor.shutdownNow();

//            boolean isTerminated = executor.awaitTermination(1, TimeUnit.DAYS);
//            System.out.println(isTerminated);
        } catch (RuntimeException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void rejectedHandler() {
        var minThread = 10;
        var maxThread = 100;
        var alive = 1;
        var aliveTime = TimeUnit.MINUTES;

        var queue = new ArrayBlockingQueue<Runnable>(10);

        var rejectedHandler = new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("Task : " + r + " is rejected");
            }
        };

        try (var executor = new ThreadPoolExecutor(minThread, maxThread, alive, aliveTime, queue, rejectedHandler)){
            for (int i = 0; i < 1000; i++) {
                final var task = i;
                executor.execute(() -> {
                    try {
                        Thread.sleep(1_000);
                        System.out.println("Task " + task + " from thread : " + Thread.currentThread().getName());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                });
            }

            boolean isTerminated = executor.awaitTermination(1, TimeUnit.DAYS);
            System.out.println(isTerminated);
        } catch (RuntimeException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static class LogRejectedExecutionHandler implements RejectedExecutionHandler {

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            System.out.println("Task : " + r + " is rejected");
        }
    }
}
