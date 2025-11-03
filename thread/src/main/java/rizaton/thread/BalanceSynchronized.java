package rizaton.thread;

public class BalanceSynchronized {

    private Long value;

    public BalanceSynchronized(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public static void transfer(BalanceSynchronized from, BalanceSynchronized to, Long value) throws InterruptedException {
        synchronized (from) {
            Thread.sleep(1_000L);
            from.setValue(from.getValue() - value);
        }
        synchronized (to) {
            Thread.sleep(1_000L);
            to.setValue(to.getValue() + value);
        }
    }
}
