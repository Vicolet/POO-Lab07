package util;

import java.util.Arrays;

/**
 * A test class for the Stack implementation.
 */
public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        // Display the stack (should be 40 30 20 10)
        System.out.println("Stack: " + stack);

        // Test pop
        System.out.println("Pop: " + stack.pop()); // Should remove and return 40
        System.out.println("Stack: " + stack);     // Should now be 30 20 10

        // Test toArray
        System.out.println("Stack to array: " + Arrays.toString(stack.toArray())); // Should return [30, 20, 10]

        // Test iterator
        System.out.println("Iterator:");
        for (Integer i : stack) {
            System.out.print(i + " "); // Should print 30 20 10
        }
        System.out.println();
    }
}
