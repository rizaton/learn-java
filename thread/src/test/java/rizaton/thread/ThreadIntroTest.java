package rizaton.thread;

import org.junit.jupiter.api.Test;

public class ThreadIntroTest {

    @Test
    void mainThread() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName);
    }

    @Test
    void createThread() {
        Runnable runnable = () -> System.out.println("Hello from Thread: " + Thread.currentThread().getName());

        var thread1 = new Thread(runnable);
        var thread2 = new Thread(runnable);
        var thread3 = new Thread(runnable);
        var thread4 = new Thread(runnable);

        runnable.run();

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        System.out.println("Closing from Thread: " + Thread.currentThread().getName());
    }

    @Test
    void threadSleep() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(2_000);
                System.out.println("Thread sleep: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        var thread = new Thread(runnable);
        thread.start();

        System.out.println("Program Executed");

        Thread.sleep(3_000);

    }

    @Test
    void threadJoin() throws InterruptedException {
        Runnable runnable = () -> {
            try {
                Thread.sleep(2_000);
                System.out.println("Thread sleep: " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        };

        var thread = new Thread(runnable);
        thread.start();
        System.out.println("Waiting Execution");
        thread.join();
        System.out.println("Program Executed");
    }

    @Test
    void threadInterrupt() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Runnable: " + i);
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        var thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5_000);
        thread.interrupt();
        System.out.println("Waiting Execution");
        thread.join();
        System.out.println("Program Executed");
    }

    @Test
    void threadCorrectInterrupt() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Runnable: " + i);
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        };

        var thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5_000);
        thread.interrupt();
        System.out.println("Waiting Execution");
        thread.join();
        System.out.println("Program Executed");
    }

    @Test
    void threadCorrectInterrupted2() throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                if (Thread.interrupted()) {
                    return;
                }
                System.out.println("Runnable: " + i);
            }
        };

        var thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5_000);
        thread.interrupt();
        System.out.println("Waiting Execution");
        thread.join();
        System.out.println("Program Executed");
    }

    @Test
    void threadName() {
        var thread = new Thread(() -> {
            System.out.println("Hello from Thread: " + Thread.currentThread().getName());
        });
        thread.setName("Iza");
        thread.start();
    }

    @Test
    void threadState() throws InterruptedException {
        var thread = new Thread(() -> {
            System.out.println(Thread.currentThread().getState());
            System.out.println("Hello from Thread: " + Thread.currentThread().getName());
        });
        System.out.println(thread.getState());
        thread.setName("Iza");
        thread.start();
        thread.join();
        System.out.println(thread.getState());

    }

    @Test
    void threadDaemon() {

    }
}
