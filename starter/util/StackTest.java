package util;

import java.util.Arrays;

public class StackTest {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        // Stack: 40 30 20 10
        System.out.println("Stack: " + stack);

        // Test pop
        System.out.println("Pop: " + stack.pop());
        System.out.println("Stack: " + stack);

        // Test toArray
        System.out.println("Stack to array: " + Arrays.toString(stack.toArray()));

        // Test iterator
        System.out.println("Iterator:");
        for (Integer i : stack) {
            System.out.println(i + " ");
        }
        System.out.println();
    }
}