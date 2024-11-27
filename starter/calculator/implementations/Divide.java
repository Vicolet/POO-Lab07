package calculator.implementations;

import calculator.operator.BinaryOperator;
import state.State;

/**
 * Represents the division operator.
 * <p>
 * This operator divides the top value of the stack (numerator) by the current value
 * (denominator) and updates the calculator's state with the result. If division by zero
 * occurs, an error message is set in the calculator's state.
 * </p>
 *
 * @author Léon Surbeck
 * @author Victor Nicolet
 * @date 20.11.2024
 */
public class Divide extends BinaryOperator {

    /**
     * Performs the division operation.
     * <p>
     * Divides the numerator {@code left} by the denominator {@code right}.
     * Returns {@code Double.NaN} if {@code right} is zero.
     * </p>
     *
     * @param left  the numerator (value from the stack)
     * @param right the denominator (current value)
     * @return the result of dividing {@code left} by {@code right}, or {@code Double.NaN} if division by zero
     */
    @Override
    protected double binaryOperation(double left, double right) {
        if (right == 0) {
            return Double.NaN; // Handle division by zero
        }
        return left / right; // Perform division
    }

    /**
     * Executes the division operation and handles any errors.
     * <p>
     * This method validates the state, retrieves the numerator from the stack,
     * and uses the current value as the denominator. If the denominator is zero,
     * it sets an error in the state. Otherwise, it updates the state with the division result.
     * </p>
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        if (state.getStack().isEmpty()) {
            state.setError("Error: Empty stack"); // Handle empty stack
            return;
        }

        double left = state.pop();  // Retrieve numerator from the stack
        double right = state.getCurrentValue();  // Retrieve denominator

        double result = binaryOperation(left, right); // Perform division

        if (Double.isNaN(result)) {
            state.setError("Error: Division by zero"); // Handle division by zero
            return;
        }

        state.setCurrentValue(result); // Update state with result
        state.setNewEntry(true);
        state.setResultDisplayed(true);
    }
}
