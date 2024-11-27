package calculator.implementations;

import state.State;

/**
 * Represents the clear all operator.
 * <p>
 * This operator clears the stack, resets the current value to 0, and removes any
 * errors from the calculator's state. It prepares the state for a new entry.
 * </p>
 *
 * @author Léon Surbeck
 * @author Victor Nicolet
 * @date 20.11.2024
 */
public class ClearAll extends ClearError {

    /**
     * Executes the clear all operation on the calculator's state.
     * <p>
     * This method first performs the "Clear Error" (CE) operation, which resets
     * the current value and clears any existing errors. Then it clears the entire stack.
     * </p>
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        super.execute(state); // Perform CE operation first
        state.clearAll();     // Clear the entire stack
    }
}
