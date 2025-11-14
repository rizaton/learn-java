package rizaton.thread;

import org.junit.jupiter.api.Test;

import java.util.Random;
import java.util.concurrent.*;

public class CompletableFutureTest {

    private final ExecutorService executor = Executors.newFixedThreadPool(10);

    private final Random random = new Random();

    public CompletableFuture<String> getValue(){
        CompletableFuture<String> future = new CompletableFuture<>();

        executor.execute(() -> {
            try {
                Thread.sleep(2_000);
                future.complete("The task is done");
            } catch (InterruptedException e) {
                future.completeExceptionally(e);
            }
        });

        return future;
    }

    @Test
    void create() throws ExecutionException, InterruptedException {
        Future<String> futureValue1 = getValue();

        System.out.println(futureValue1.get());
    }

    private void execute (CompletableFuture<String> future, String value){
        executor.execute(() -> {
            try {
                Thread.sleep(1000 + random.nextInt(5000));
                future.complete(value);
            } catch (InterruptedException e) {
                future.completeExceptionally(e);
            }
        });
    }

    public Future<String> getFastest() {
        CompletableFuture<String> future = new CompletableFuture<>();

        execute(future, "Thread1");
        execute(future, "Thread2");
        execute(future, "Thread3");

        return future;
    }

    @Test
    void fastestFuture() throws ExecutionException, InterruptedException {
        System.out.println(getFastest().get());
    }

    @Test
    void completionStage() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = getValue();

        CompletableFuture<String[]> future2 = future.thenApply(String::toUpperCase)
                .thenApply(string -> string.split(" "));

        String[] strings = future2.get();
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
