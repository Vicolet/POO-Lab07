package calculator.implementations;

import calculator.operator.BinaryOperator;

/**
 * Represents the multiplication operator.
 * <p>
 * This operator retrieves the top value from the stack, multiplies it by
 * the current value, and updates the calculator's state with the result.
 */
public class Multiply extends BinaryOperator {

    /**
     * Performs the multiplication operation.
     *
     * @param left  the left operand (value from the stack)
     * @param right the right operand (current value)
     * @return the result of multiplying {@code left} by {@code right}
     */
    @Override
    protected double binaryOperation(double left, double right) {
        return left * right; // Specific logic for multiplication
    }
}
