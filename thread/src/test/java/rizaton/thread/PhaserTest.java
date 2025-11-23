package rizaton.thread;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class PhaserTest {

    @Test
    void createPhaser() {
        final Phaser phaser = new Phaser();
        final ExecutorService executor = Executors.newFixedThreadPool(10);

        phaser.bulkRegister(5);
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                try {
                    System.out.println("STask Started");
                    Thread.sleep(2_000);
                    System.out.println("Task Ended");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    phaser.arrive();
                }
            });
        }

        executor.close();
    }

    @Test
    void phaserCountdownLatch() {
        final Phaser phaser = new Phaser();
        final ExecutorService executor = Executors.newFixedThreadPool(10);

        phaser.bulkRegister(5);
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                try {
                    System.out.println("STask Started");
                    Thread.sleep(2_000);
                    System.out.println("Task Ended");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    phaser.arrive();
                }
            });
        }

        executor.execute(() -> {
            phaser.awaitAdvance(0);
            System.out.println("All Task Done");
        });

        executor.close();
    }

    @Test
    void phaserCyclicBarrier() {
        final Phaser phaser = new Phaser();
        final ExecutorService executor = Executors.newFixedThreadPool(15);

        phaser.bulkRegister(5);
        for (int i = 0; i < 5; i++) {
            executor.execute(() -> {
                phaser.arriveAndAwaitAdvance();
                System.out.println("Done");
            });
        }

        executor.close();
    }

}
