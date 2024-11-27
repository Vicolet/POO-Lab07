package calculator.implementations;

import calculator.operator.BinaryOperator;
import state.State;

/**
 * Represents the division operator.
 */
public class Divide extends BinaryOperator {

    /**
     * Performs the division operation.
     *
     * @param left  the numerator (value from the stack)
     * @param right the denominator (current value)
     * @return the result of dividing {@code left} by {@code right}, or NaN if division by zero
     */
    @Override
    protected double binaryOperation(double left, double right) {
        if (right == 0) {
            return Double.NaN; // Return NaN for division by zero
        }
        return left / right; // Perform the division
    }

    /**
     * Executes the division operation and handles errors like division by zero.
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

        // Perform the operation
        double result = binaryOperation(left, right);

        // Handle division by zero
        if (Double.isNaN(result)) {
            state.setError("Error: Division by zero");
            return;
        }

        // Update the state with the valid result
        state.setCurrentValue(result);
        state.setNewEntry(true);
        state.setResultDisplayed(true);
    }
}
