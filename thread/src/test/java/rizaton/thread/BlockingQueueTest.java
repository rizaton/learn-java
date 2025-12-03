package rizaton.thread;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.concurrent.*;

public class BlockingQueueTest {

    @Test
    void arrayBlockingQueue() throws InterruptedException {
        final BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
        final ExecutorService executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    queue.put("Data");
                    System.out.println("Finish Put Data");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2_000);
                    String value = queue.take();
                    System.out.println("Received Data: " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.close();
    }

    @Test
    void linkedBlockingQueue() throws InterruptedException {
        final BlockingQueue<String> queue = new LinkedBlockingQueue<>();
        final ExecutorService executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                try {
                    queue.put("Data");
                    System.out.println("Finish Put Data");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2_000);
                    String value = queue.take();
                    System.out.println("Received Data: " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.close();
    }

    @Test
    void priorityBlockingQueue() throws InterruptedException {
        final BlockingQueue<Integer> queue = new PriorityBlockingQueue<>(10, Comparator.reverseOrder());
        final ExecutorService executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            int index = i;
            executor.execute(() -> {
                try {
                    queue.put(index);
                    System.out.println("Finish Put Data: " + index);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2_000);
                    Integer value = queue.take();
                    System.out.println("Received Data: " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.close();
    }

    @Test
    void delayedBlockingQueue() throws InterruptedException {
        final BlockingQueue<ScheduledFuture<String>> queue = new DelayQueue<>();
        final ExecutorService executor = Executors.newFixedThreadPool(20);
        final ScheduledExecutorService scheduled = Executors.newScheduledThreadPool(10);

        for (int i = 1; i <= 10; i++) {
            int index = i;
            queue.put(scheduled.schedule(() -> "Data " + index, i, TimeUnit.SECONDS));
        }

        executor.execute(() -> {
            while (true) {
                try {
                    ScheduledFuture<String> value = queue.take();
                    System.out.println("Received Data: " + value.get());
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.close();
    }

    @Test
    void synchronousBlockingQueue() throws InterruptedException {
        final BlockingQueue<String> queue = new SynchronousQueue<>();
        final ExecutorService executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            int index = i;
            executor.execute(() -> {
                try {
                    queue.put("Data: " + index);
                    System.out.println("Finish Put Data: " + index);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2_000);
                    String value = queue.take();
                    System.out.println("Received Data: " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.close();
    }

    @Test
    void linkedBlockingDeque() throws InterruptedException {
        final BlockingDeque<String> queue = new LinkedBlockingDeque<>();
        final ExecutorService executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            final int index = i;
                try {
                    queue.putLast("Data: " + index);
                    System.out.println("Finish Put Data: " + index);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }
        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2_000);
                    String value = queue.takeFirst();
                    System.out.println("Received Data: " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.close();
    }

    @Test
    void transferBlockingQueue() throws InterruptedException {
        final TransferQueue<String> queue = new LinkedTransferQueue<>();
        final ExecutorService executor = Executors.newFixedThreadPool(20);

        for (int i = 0; i < 10; i++) {
            final int index = i;
            executor.execute(() -> {
                try {
                    queue.transfer("Data: " + index);
                    System.out.println("Finish Put Data: " + index);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        executor.execute(() -> {
            while (true) {
                try {
                    Thread.sleep(2_000);
                    String value = queue.take();
                    System.out.println("Received Data: " + value);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        executor.close();
    }
}
