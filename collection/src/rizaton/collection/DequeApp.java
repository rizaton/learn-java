package rizaton.collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class DequeApp {
    public static void main(String[] args) {

//        Deque<String> stack = new ArrayDeque<>();
        Deque<String> stack = new LinkedList<>();

//        stack.offerFirst("John");
//        stack.offerFirst("Mary");
//        stack.offerFirst("Robert");
//        stack.offerFirst("Zayn");
        stack.offerLast("John");
        stack.offerLast("Mary");
        stack.offerLast("Robert");
        stack.offerLast("Zayn");

        System.out.println(stack.pollLast());
        System.out.println(stack.pollLast());
        System.out.println(stack.pollLast());
        System.out.println(stack.pollLast());

        Deque<String> queue = new LinkedList<>();
        queue.offerLast("John");
        queue.offerLast("Mary");
        queue.offerLast("Robert");
        queue.offerLast("Zayn");

        System.out.println(queue.pollFirst());
        System.out.println(queue.pollFirst());
        System.out.println(queue.pollFirst());
        System.out.println(queue.pollFirst());
        
    }
}
