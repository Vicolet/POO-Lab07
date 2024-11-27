package calculator.operator;

import state.State;

/**
 * Base class for division-related operations.
 */
public abstract class DivisionBase extends BinaryOperator {

    /**
     * Performs a division-related operation. Handles division by zero.
     *
     * @param left  the numerator (value from the stack)
     * @param right the denominator (current value)
     * @return the result of the operation, or NaN if division by zero
     */
    @Override
    protected double operation(double left, double right) {
        if (right == 0) {
            return Double.NaN; // Division by zero
        }
        return divide(left, right);
    }

    /**
     * Defines the specific division logic for the derived classes.
     *
     * @param left  the numerator
     * @param right the denominator
     * @return the result of the division
     */
    protected abstract double divide(double left, double right);
}
