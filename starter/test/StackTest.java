package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Stack;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Stack} class.
 * <p>
 * This class verifies the functionality of a generic stack implementation,
 * including basic operations such as push, pop, and iteration.
 * </p>
 *
 * @author Léon Surbeck
 * @author Victor Nicolet
 * @date 20.11.2024
 */
public class StackTest {

    private Stack<Integer> stack;

    /**
     * Sets up the test environment before each test.
     * <p>
     * Initializes an empty stack to ensure a clean state for each test case.
     * </p>
     */
    @BeforeEach
    public void setUp() {
        stack = new Stack<>(); // Initialize a new stack before each test
    }

    /**
     * Tests the {@code push} operation and the {@code toString} representation of the stack.
     * <p>
     * Validates that pushed elements are added in LIFO order and appear correctly
     * in the string representation.
     * </p>
     */
    @Test
    public void testPushAndToString() {
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        assertEquals("40 30 20 10", stack.toString(), "Stack should display elements in LIFO order");
    }

    /**
     * Tests the {@code pop} operation.
     * <p>
     * Verifies that elements are removed in LIFO order, and the stack's state
     * is updated correctly after each operation.
     * </p>
     */
    @Test
    public void testPop() {
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        assertEquals(40, stack.pop(), "Popped value should be the most recently added (40)");
        assertEquals(30, stack.pop(), "Popped value should now be 30");

        assertEquals("20 10", stack.toString(), "Stack should display remaining elements in LIFO order");
        assertFalse(stack.isEmpty(), "Stack should not be empty after popping some elements");

        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());

        assertTrue(stack.isEmpty(), "Stack should be empty after popping all elements");
    }

    /**
     * Tests the {@code toArray} method.
     * <p>
     * Verifies that the stack is correctly converted to an array in LIFO order.
     * </p>
     */
    @Test
    public void testToArray() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        Object[] array = stack.toArray();
        assertArrayEquals(new Object[]{30, 20, 10}, array, "Array representation should match stack elements in LIFO order");
    }

    /**
     * Tests the stack iterator.
     * <p>
     * Validates that the iterator traverses the stack in LIFO order.
     * </p>
     */
    @Test
    public void testIterator() {
        stack.push(10);
        stack.push(20);
        stack.push(30);

        Iterator<Integer> iterator = stack.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(30, iterator.next());
        assertEquals(20, iterator.next());
        assertEquals(10, iterator.next());
        assertFalse(iterator.hasNext(), "Iterator should not have more elements after traversing the stack");
    }

    /**
     * Tests the {@code isEmpty} method.
     * <p>
     * Verifies that the stack correctly identifies whether it is empty after push and pop operations.
     * </p>
     */
    @Test
    public void testIsEmpty() {
        assertTrue(stack.isEmpty(), "Stack should be empty when initialized");

        stack.push(10);
        assertFalse(stack.isEmpty(), "Stack should not be empty after adding elements");

        stack.pop();
        assertTrue(stack.isEmpty(), "Stack should be empty after removing all elements");
    }

    /**
     * Tests the {@code size} method.
     * <p>
     * Validates that the stack size is updated correctly after push and pop operations.
     * </p>
     */
    @Test
    public void testSize() {
        assertEquals(0, stack.size(), "Stack size should be 0 when initialized");

        stack.push(10);
        stack.push(20);
        assertEquals(2, stack.size(), "Stack size should reflect the number of pushed elements");

        stack.pop();
        assertEquals(1, stack.size(), "Stack size should decrease after popping an element");

        stack.pop();
        assertEquals(0, stack.size(), "Stack size should return to 0 after removing all elements");
    }

    /**
     * Tests popping from an empty stack.
     * <p>
     * Verifies that attempting to pop an empty stack throws a {@code NoSuchElementException}.
     * </p>
     *
     * @throws java.util.NoSuchElementException if the stack is empty
     */
    @Test
    public void testPopFromEmptyStack() {
        assertThrows(java.util.NoSuchElementException.class, stack::pop, "Popping from an empty stack should throw NoSuchElementException");
    }
}
