package calculator.operators;

import calculator.Operator;
import calculator.State;

/**
 * Represents the enter operator. This operator pushes the current value
 * onto the stack, resets the current value, and prepares the calculator's
 * state for a new entry.
 */
public class Enter extends Operator {

    /**
     * Executes the enter operation on the calculator's state.
     * <p>
     * This operation pushes the current value onto the stack, resets the
     * current value to 0, and prepares the state for a new entry.
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        state.pushCurrentValue();  // Push the current value onto the stack
        state.setCurrentValue(0.0); // Reset the current value to 0
        state.setNewEntry(true);    // Prepare for a new entry
    }
}
