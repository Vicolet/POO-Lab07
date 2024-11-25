package calculator.operators;

import calculator.Operator;
import calculator.State;

/**
 * Represents the clear error operator. This operator resets the current value,
 * clears any existing error messages, and prepares the state for a new entry.
 */
public class ClearError extends Operator {

    /**
     * Executes the clear error operation on the calculator's state.
     * <p>
     * This operation resets the current value to 0, removes any existing error messages,
     * disables decimal mode, and prepares the state for a new entry.
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        state.setCurrentValue(0.0);  // Resets the current value to 0
        state.clearError();          // Clears any error messages
        state.setDecimalMode(false); // Disables decimal mode
        state.setNewEntry(true);     // Prepares for a new entry
    }
}
