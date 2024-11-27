package calculator.implementations;

import calculator.operator.UnaryOperator;
import state.State;

/**
 * Represents the inverse operator (1/x).
 * <p>
 * This operator calculates the reciprocal of the current value and updates
 * the calculator's state. Division by zero results in an error message.
 * </p>
 *
 * @author Léon Surbeck
 * @author Victor Nicolet
 * @date 20.11.2024
 */
public class Inverse extends UnaryOperator {

    /**
     * Performs the inverse operation.
     * <p>
     * Calculates the reciprocal of the given value. If the value is zero,
     * the method returns NaN to indicate a division by zero error.
     * </p>
     *
     * @param value the denominator (current value)
     * @param state the current state of the calculator
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
     * Executes the inverse operation and updates the calculator's state.
     * <p>
     * If the current value is zero, sets an error message. Otherwise, updates
     * the state with the reciprocal of the current value.
     * </p>
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        double current = state.getCurrentValue();

        // Perform the operation
        double result = unaryOperation(current, state);

        // Handle division by zero or update the state
        if (Double.isNaN(result)) {
            state.setError("Error: Division by zero");
        } else {
            state.setCurrentValue(result); // Update the state with the result
            state.setNewEntry(true);
            state.setResultDisplayed(true);
        }
    }
}
