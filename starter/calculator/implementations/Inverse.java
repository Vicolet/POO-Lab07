package calculator.implementations;

import calculator.operator.DivisionBase;
import state.State;

/**
 * Represents the inverse operator (1/x).
 */
public class Inverse extends DivisionBase {

    /**
     * Implements the logic for calculating the reciprocal.
     *
     * @param left  unused (set to 1 in this case)
     * @param right the denominator
     * @return the result of 1 divided by {@code right}
     */
    @Override
    protected double divide(double left, double right) {
        return 1 / right;
    }

    /**
     * Overriding the execute method to ignore the stack.
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        double current = state.getCurrentValue();

        // Handle division by zero
        if (current == 0) {
            state.setError("Error: Division by zero");
            return;
        }

        state.setCurrentValue(1 / current);
        state.setNewEntry(true);
        state.setResultDisplayed(true);
    }

    @Override
    protected double operation(double value) {
        return 0;
    }
}
