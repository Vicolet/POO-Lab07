package calculator.operators;

import calculator.Operator;
import calculator.State;

/**
 * Represents the clear all operator. This operator clears the stack,
 * resets the current value, and removes any errors from the calculator's state.
 */
public class ClearAll extends Operator {

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
        state.clearAll();           // Clears the stack and resets errors
        state.setCurrentValue(0.0); // Resets the current value to 0
        state.setNewEntry(true);    // Prepares for a new entry
    }
}
