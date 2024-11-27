package calculator.implementations;

import calculator.operator.BinaryOperator;

/**
 * Represents the addition operator.
 * <p>
 * This operator adds the top value of the stack to the current value
 * and updates the calculator's state with the result.
 */
public class Add extends BinaryOperator {

    /**
     * Performs the addition operation.
     *
     * @param left  the value from the stack
     * @param right the current value
     * @return the result of adding {@code left} and {@code right}
     */
    @Override
    protected double binaryOperation(double left, double right) {
        return left + right; // Perform addition
    }
}
