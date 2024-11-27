package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import state.State;

import static org.junit.jupiter.api.Assertions.*;

public class StateTest {

    private State state;

    @BeforeEach
    public void setUp() {
        state = new State(); // Initialize a fresh state for each test
    }

    /**
     * Test stack operations (push, pop, isEmpty).
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
     * Test setting and retrieving the current value.
     */
    @Test
    public void testCurrentValue() {
        state.setCurrentValue(42.0);
        assertEquals(42.0, state.getCurrentValue(), "Current value should be updated to 42.0");

        state.setCurrentValue(-3.14);
        assertEquals(-3.14, state.getCurrentValue(), "Current value should be updated to -3.14");
    }

    /**
     * Test storing and recalling from memory.
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
     * Test error management.
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
     * Test clearing all values.
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
        assertEquals(0.0, state.recallFromMemory(), "Memory should be cleared");}

    /**
     * Test indicator flags (isNewEntry, isResultDisplayed, isDecimalMode).
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
     * Test conversion of stack to array.
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
     * Test current value as string formatting.
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
