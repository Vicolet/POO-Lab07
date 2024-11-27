package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import state.State;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link State} class.
 * <p>
 * This class tests the internal state management of the calculator, including
 * stack operations, current value management, memory handling, error management,
 * and formatting utilities.
 * </p>
 *
 * @author Léon Surbeck
 * @author Victor Nicolet
 * @date 20.11.2024
 */
public class StateTest {

    private State state;

    /**
     * Initializes a fresh {@link State} object before each test.
     */
    @BeforeEach
    public void setUp() {
        state = new State(); // Initialize a fresh state for each test
    }

    /**
     * Tests stack operations: push, pop, and isEmpty.
     * <p>
     * Verifies that elements are pushed and popped in LIFO order, and the stack
     * correctly reflects its state after operations.
     * </p>
     */
    @Test
    public void testStackOperations() {
        assertTrue(state.getStack().isEmpty(), "Stack should initially be empty");

        state.pushCurrentValue(); // Push default value (0.0)
        assertFalse(state.getStack().isEmpty(), "Stack should not be empty after pushing");

        Double poppedValue = state.pop();
        assertEquals(0.0, poppedValue, "Popped value should match the last pushed value");

        assertTrue(state.getStack().isEmpty(), "Stack should be empty after popping all elements");
    }

    /**
     * Tests setting and retrieving the current value.
     * <p>
     * Verifies that the current value is updated and retrieved correctly.
     * </p>
     */
    @Test
    public void testCurrentValue() {
        state.setCurrentValue(42.0);
        assertEquals(42.0, state.getCurrentValue(), "Current value should be updated to 42.0");

        state.setCurrentValue(-3.14);
        assertEquals(-3.14, state.getCurrentValue(), "Current value should be updated to -3.14");
    }

    /**
     * Tests storing and recalling values from memory.
     * <p>
     * Verifies that memory operations work as expected, including overwriting stored values.
     * </p>
     */
    @Test
    public void testMemoryOperations() {
        state.setCurrentValue(99.99);
        state.storeInMemory();

        state.setCurrentValue(0.0);
        assertEquals(99.99, state.recallFromMemory(), "Recalled memory value should match the stored value");

        state.setCurrentValue(42.0);
        state.storeInMemory();
        assertEquals(42.0, state.recallFromMemory(), "Recalled memory value should match the most recently stored value");
    }

    /**
     * Tests error management: setting, retrieving, and clearing errors.
     * <p>
     * Verifies that errors are handled correctly and cleared appropriately.
     * </p>
     */
    @Test
    public void testErrorHandling() {
        assertNull(state.getError(), "Error should initially be null");

        state.setError("Division by zero");
        assertEquals("Division by zero", state.getError(), "Error should be updated correctly");

        state.clearError();
        assertNull(state.getError(), "Error should be cleared after calling clearError()");
    }

    /**
     * Tests clearing all state values.
     * <p>
     * Verifies that all state attributes, including stack, memory, and current value,
     * are reset to their initial states.
     * </p>
     */
    @Test
    public void testClearAll() {
        state.setCurrentValue(42.0);
        state.pushCurrentValue();
        state.storeInMemory();
        state.setError("Some error");

        state.clearAll();

        assertEquals(0.0, state.getCurrentValue(), "Current value should be reset to 0.0");
        assertTrue(state.getStack().isEmpty(), "Stack should be cleared");
        assertNull(state.getError(), "Error should be cleared");
        assertEquals(0.0, state.recallFromMemory(), "Memory should be cleared");
    }

    /**
     * Tests indicator flags: isNewEntry, isResultDisplayed, and isDecimalMode.
     * <p>
     * Verifies that the flags are updated correctly and maintain their expected behavior.
     * </p>
     */
    @Test
    public void testFlags() {
        assertTrue(state.isNewEntry(), "isNewEntry should initially be true");

        state.setNewEntry(false);
        assertFalse(state.isNewEntry(), "isNewEntry should be false after setting it to false");

        assertFalse(state.isResultDisplayed(), "isResultDisplayed should initially be false");
        state.setResultDisplayed(true);
        assertTrue(state.isResultDisplayed(), "isResultDisplayed should be true after setting it to true");

        assertFalse(state.isDecimalMode(), "isDecimalMode should initially be false");
        state.setDecimalMode(true);
        assertTrue(state.isDecimalMode(), "isDecimalMode should be true after setting it to true");
    }

    /**
     * Tests converting the stack to an array of strings.
     * <p>
     * Verifies that the array representation matches the expected LIFO order.
     * </p>
     */
    @Test
    public void testStackToArray() {
        state.setCurrentValue(1.1);
        state.pushCurrentValue();

        state.setCurrentValue(2.2);
        state.pushCurrentValue();

        state.setCurrentValue(3.3);
        state.pushCurrentValue();

        String[] stackArray = state.getStackArray();
        assertArrayEquals(new String[]{"3.3", "2.2", "1.1"}, stackArray, "Stack array should match the expected values");
    }

    /**
     * Tests formatting of the current value as a string.
     * <p>
     * Verifies that integers are displayed without decimal points, and doubles are
     * formatted correctly.
     * </p>
     */
    @Test
    public void testCurrentValueAsString() {
        state.setCurrentValue(42.0);
        assertEquals("42", state.getCurrentValueAsString(), "Formatted value should not include .0 for integers");

        state.setCurrentValue(3.14);
        assertEquals("3.14", state.getCurrentValueAsString(), "Formatted value should match the double precision");

        state.setCurrentValue(0.0);
        assertEquals("0", state.getCurrentValueAsString(), "Formatted value should display 0 for zero");
    }
}
