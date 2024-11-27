package calculator.implementations;

import calculator.operator.UnaryOperator;
import state.State;

/**
 * Represents the inverse operator (1/x).
 */
public class Inverse extends UnaryOperator {

    /**
     * Performs the inverse operation.
     *
     * @param value the denominator (current value)
     * @return the reciprocal of {@code value}, or NaN if {@code value} is zero
     */
    @Override
    protected double unaryOperation(double value, State state) {
        if (value == 0) {
            return Double.NaN; // Return NaN for division by zero
        }
        return 1 / value; // Perform the inversion
    }

    /**
     * Executes the inverse operation and handles errors like division by zero.
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        double current = state.getCurrentValue();

        // Perform the operation
        double result = unaryOperation(current, state);

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
