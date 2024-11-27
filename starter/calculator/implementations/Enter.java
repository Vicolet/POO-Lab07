package calculator.implementations;

import calculator.operator.DefaultOperator;
import state.State;

/**
 * Represents the enter operator. This operator pushes the current value
 * onto the stack, resets the current value, and prepares the calculator's
 * state for a new entry.
 */
public class Enter extends DefaultOperator {

    /**
     * Constructor for Enter operator.
     */
    public Enter() {
        super(); // Call DefaultOperator's constructor if needed
    }

    @Override
    public void execute(State state) {
        state.pushCurrentValue();   // Push the current value onto the stack
        state.setCurrentValue(0.0); // Reset the current value to 0
        state.setNewEntry(true);    // Prepare for a new entry
    }

    @Override
    protected double operation(double value) {
        // No operation is performed for Enter
        return value;
    }
}
