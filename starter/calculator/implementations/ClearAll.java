package calculator.implementations;

import state.State;

/**
 * Represents the clear all operator. This operator clears the stack,
 * resets the current value, and removes any errors from the calculator's state.
 */
public class ClearAll extends ClearError {

    /**
     * Executes the clear all operation on the calculator's state.
     * <p>
     * This operation clears the stack, resets the current value to 0,
     * removes any existing errors, and prepares the state for a new entry.
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        super.execute(state); // Perform CE operation first
        state.clearAll();     // Clear the entire stack
    }
}
