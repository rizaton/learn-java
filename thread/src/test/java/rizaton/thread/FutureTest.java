package rizaton.thread;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FutureTest {

    @Test
    void futureCreate() {
        try (ExecutorService executor = Executors.newSingleThreadExecutor()) {
            Callable<String> callable = () -> {
                Thread.sleep(5_000);
                return "hello World!";
            };

            Future<String> future = executor.submit(callable);

            while (!future.isDone()) {
                System.out.println("Waiting for Result");
                try {
                    //noinspection BusyWait
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println(future.get());

        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void futureCancel() {
        try (ExecutorService executor = Executors.newSingleThreadExecutor()) {
            Callable<String> callable = () -> {
                Thread.sleep(5_000);
                return "hello World!";
            };

            Future<String> future = executor.submit(callable);
            System.out.println("Future Created");

            Thread.sleep(2_000);
            future.cancel(true);

            System.out.println("isCancelled : " + future.isCancelled());

            String value = future.get();
            System.out.println(value);

        } catch (InterruptedException | ExecutionException e) {
            Assertions.assertThrows(Exception.class, (Executable) e);
        }
    }

    @Test
    void callableInvokeAll() throws InterruptedException, ExecutionException {
        try (ExecutorService executor = Executors.newFixedThreadPool(10)) {
            List<Callable<String>> callables = IntStream.range(1, 11)
                    .mapToObj(operand -> (Callable<String>) () -> {
                        Thread.sleep(operand * 500L);
                        return String.valueOf(operand);
                    }).toList();

            List<Future<String>> futures = executor.invokeAll(callables);

            for (Future<String> future : futures) {
                System.out.println(future.get());
            }
        }
    }

    @Test
    void callableInvokeAny() throws InterruptedException, ExecutionException {
        try (ExecutorService executor = Executors.newFixedThreadPool(10)) {
            List<Callable<String>> callables = IntStream.range(1, 11)
                    .mapToObj(operand -> (Callable<String>) () -> {
                        Thread.sleep(operand * 500L);
                        return String.valueOf(operand);
                    }).toList();

            String value = executor.invokeAny(callables);
            System.out.println(value);
        }
    }
}
