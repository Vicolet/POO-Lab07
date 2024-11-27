package calculator.implementations;

import calculator.operator.DivisionBase;
import state.State;

/**
 * Represents the division operator. This operator divides the top value
 * of the stack by the current value and updates the state.
 */
public class Divide extends DivisionBase {

    protected double getLeftOperand(State state) {
        // Retrieve the top value from the stack
        return state.getStack().isEmpty() ? 0.0 : state.pop();
    }

    @Override
    protected double operation(double value) {
        return 0;
    }
}
