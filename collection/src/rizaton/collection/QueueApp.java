package rizaton.collection;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class QueueApp {
    public static void main(String[] args) {

//        Queue<String> queue = new ArrayDeque<>();
        Queue<String> queue = new PriorityQueue<>();
//        Queue<String> queue = new LinkedList<>();
//        for (int i = 0; i < 20; i++) {
//            queue.add("" + i);
//        }
        queue.add("John");
        queue.add("Mary");
        queue.add("Jane");
        queue.add("Julie");
        queue.add("Zane");

        for (String next = queue.poll(); next != null; next = queue.poll()) {
            System.out.println(next);
        }

        System.out.println(queue.size());

    }
}
