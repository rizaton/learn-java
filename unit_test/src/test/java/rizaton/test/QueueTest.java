package rizaton.test;

import org.junit.jupiter.api.*;

import java.util.LinkedList;
import java.util.Queue;

@DisplayName("A Queue")
public class QueueTest {

    private Queue<String> queue;

    @Nested
    @DisplayName("when new")
    public class WhenNew {

        @BeforeEach
        public void setUp()
        {
            queue = new LinkedList<>();
        }

        @Test
        @DisplayName("when offer 1, size must be 1")
        public void offerNewData() {
            queue.offer("test1");
            Assertions.assertEquals(1, queue.size());
        }

        @Test
        @DisplayName("when offer 2, size must be 2")
        public void offerMoreData() {
            queue.offer("test1");
            queue.offer("test2");
            Assertions.assertEquals(2, queue.size());
        }

    }


}
