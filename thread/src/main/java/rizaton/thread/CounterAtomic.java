package rizaton.thread;

import java.util.concurrent.atomic.AtomicLong;

public class CounterAtomic {

    private final AtomicLong value = new AtomicLong(0L);

    public long increment() {
        return value.incrementAndGet();
    }

    public long getValue() {
        return value.get();
    }
}
