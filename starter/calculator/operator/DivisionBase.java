package calculator.operator;

import state.State;

/**
 * Abstract base class for division-related operations.
 * <p>
 * This class provides a common framework for handling division operations,
 * including division by zero handling.
 */
public abstract class DivisionBase extends BinaryOperator {

    /**
     * Executes the division-related operation on the calculator's state.
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        // Check if the stack is empty
        if (state.getStack().isEmpty()) {
            state.setError("Error: Empty stack");
            return;
        }

        double left = state.pop();  // Get the value from the stack
        double right = state.getCurrentValue();  // Get the current value

        // Handle division by zero
        if (right == 0) {
            state.setError("Error: Division by zero");
            return;
        }

        // Perform the specific division logic
        double result = divide(left, right);

        // Update the state with the result
        state.setCurrentValue(result);
        state.setNewEntry(true);
        state.setResultDisplayed(true);
    }

    /**
     * Defines the specific division logic for derived classes.
     *
     * @param left  the numerator
     * @param right the denominator
     * @return the result of the division
     */
    protected abstract double divide(double left, double right);
}
