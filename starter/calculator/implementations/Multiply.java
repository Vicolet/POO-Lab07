package calculator.implementations;

import calculator.operator.BinaryOperator;

/**
 * Represents the multiplication operator.
 * <p>
 * This operator multiplies the top value from the stack with the current value
 * and updates the calculator's state with the resulting product.
 * </p>
 *
 * @author Léon Surbeck
 * @author Victor Nicolet
 * @date 20.11.2024
 */
public class Multiply extends BinaryOperator {

    /**
     * Performs the multiplication operation.
     * <p>
     * Multiplies the value from the stack ({@code left}) with the current value
     * ({@code right}) and returns the result.
     * </p>
     *
     * @param left  the left operand (value from the stack)
     * @param right the right operand (current value)
     * @return the result of multiplying {@code left} by {@code right}
     */
    @Override
    protected double binaryOperation(double left, double right) {
        return left * right; // Perform multiplication
    }
}
