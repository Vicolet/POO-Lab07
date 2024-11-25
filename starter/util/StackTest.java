package util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {

    private Stack<Integer> stack;

    @BeforeEach
    public void setUp() {
        stack = new Stack<>(); // Initialize a new stack before each test
    }

    @Test
    public void testPushAndToString() {
        // Push elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        // Validate the stack's toString() representation
        assertEquals("40 30 20 10", stack.toString(), "Stack should display elements in LIFO order");
    }

    @Test
    public void testPop() {
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        // Pop elements and verify the values
        assertEquals(40, stack.pop(), "Popped value should be the most recently added (40)");
        assertEquals(30, stack.pop(), "Popped value should now be 30");

        // Validate the stack's state
        assertEquals("20 10", stack.toString(), "Stack should display remaining elements in LIFO order");
        assertFalse(stack.isEmpty(), "Stack should not be empty after popping some elements");

        // Pop remaining elements
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());

        // Ensure stack is empty after all pops
        assertTrue(stack.isEmpty(), "Stack should be empty after popping all elements");
    }

    @Test
    public void testToArray() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Convert the stack to an array and validate
        Object[] array = stack.toArray();
        assertArrayEquals(new Object[]{30, 20, 10}, array, "Array representation should match stack elements in LIFO order");
    }

    @Test
    public void testIterator() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Validate the iterator traverses in LIFO order
        Iterator<Integer> iterator = stack.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(30, iterator.next());
        assertEquals(20, iterator.next());
        assertEquals(10, iterator.next());
        assertFalse(iterator.hasNext(), "Iterator should not have more elements after traversing the stack");
    }

    @Test
    public void testIsEmpty() {
        // Initially, the stack should be empty
        assertTrue(stack.isEmpty(), "Stack should be empty when initialized");

        // Add elements and validate
        stack.push(10);
        assertFalse(stack.isEmpty(), "Stack should not be empty after adding elements");

        // Remove all elements and validate
        stack.pop();
        assertTrue(stack.isEmpty(), "Stack should be empty after removing all elements");
    }

    @Test
    public void testSize() {
        // Initially, size should be 0
        assertEquals(0, stack.size(), "Stack size should be 0 when initialized");

        // Add elements and validate size
        stack.push(10);
        stack.push(20);
        assertEquals(2, stack.size(), "Stack size should reflect the number of pushed elements");

        // Remove an element and validate size
        stack.pop();
        assertEquals(1, stack.size(), "Stack size should decrease after popping an element");

        // Remove the remaining element and validate size
        stack.pop();
        assertEquals(0, stack.size(), "Stack size should return to 0 after removing all elements");
    }

    @Test
    public void testPopFromEmptyStack() {
        // Ensure popping from an empty stack throws an exception
        assertThrows(java.util.NoSuchElementException.class, stack::pop, "Popping from an empty stack should throw NoSuchElementException");
    }
}
