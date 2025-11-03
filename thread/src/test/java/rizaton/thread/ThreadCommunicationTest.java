package rizaton.thread;

import org.junit.jupiter.api.Test;

public class ThreadCommunicationTest {

    private String message = null;

    @Test
    void manual() throws InterruptedException {
        var thread1 = new Thread(() -> {
            while (message == null) {
                System.out.println(Thread.currentThread().getName() + " is Waiting");
            }
            System.out.println(message);
        });

        var thread2 = new Thread(() -> {
            try {
                Thread.sleep(1_000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            message = "Hello World!";
        });

        thread2.start();
        thread1.start();

        thread2.join();
        thread1.join();
    }

    @Test
    void waitNotify() throws InterruptedException {

        final var lock = new Object();

        var thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        var thread2 = new Thread(() -> {
            synchronized (lock) {
                message = "Hello World!";
                lock.notify();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
    }

    @Test
    void waitNotifyAll() throws InterruptedException {

        final var lock = new Object();

        var thread1 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + " say: " + message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        var thread3 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait();
                    System.out.println(Thread.currentThread().getName() + " say: " + message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        var thread2 = new Thread(() -> {
            synchronized (lock) {
                message = "Hello World!";
                lock.notifyAll();
            }
        });

        thread1.start();
        thread3.start();

        thread2.start();

        thread1.join();
        thread3.join();

        thread2.join();
    }
}
