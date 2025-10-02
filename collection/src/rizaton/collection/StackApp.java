package rizaton.collection;

import java.util.EmptyStackException;
import java.util.Stack;

public class StackApp {
    public static void main(String[] args) {

        Stack<String> stack = new Stack<>();
        stack.push("John");
        stack.push("Mary");
        stack.push("Jane");
        stack.push("Doe");

        try {
            for (var value = stack.pop(); value != null; value = stack.pop()) {
                System.out.println(value);
            }
        } catch (EmptyStackException e) {
            System.out.println("Stack is empty : " + e);
        }

    }
}
