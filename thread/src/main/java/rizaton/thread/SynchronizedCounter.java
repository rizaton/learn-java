package rizaton.thread;

public class SynchronizedCounter {

    private Long value1 = 0L;
    private Long value2 = 0L;

    public void increment() {
        value2++;
        synchronized (this) {
            value1++;
        }
    }

    public Long getValue1() {
        return value1;
    }

    public Long getValue2() {
        return value2;
    }
}
