package calculator.implementations;

import calculator.operator.BinaryOperator;

/**
 * Represents the addition operator. This operator retrieves the top value
 * from the stack, adds it to the current value, and updates the calculator's
 * state with the result.
 */
public class Add extends BinaryOperator {

    /**
     * Performs the addition operation on the given operands.
     *
     * @param left  the left operand (value from the stack)
     * @param right the right operand (current value)
     * @return the result of adding {@code left} and {@code right}
     */
    @Override
    protected double operation(double left, double right) {
        return left + right; // Perform the addition
    }

    @Override
    protected double operation(double value) {
        return 0;
    }
}
