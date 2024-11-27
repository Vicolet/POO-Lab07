package calculator.implementations;

import calculator.operator.DefaultOperator;
import state.State;

/**
 * Represents the enter operator.
 * <p>
 * Pushes the current value onto the stack and resets the current value.
 */
public class Enter extends DefaultOperator {

    @Override
    protected boolean validate(State state) {
        // Always valid, no additional checks required
        return true;
    }

    @Override
    protected void performOperation(State state) {
        state.pushCurrentValue();   // Push current value to the stack
        state.setCurrentValue(0.0); // Reset current value to 0
    }
}
