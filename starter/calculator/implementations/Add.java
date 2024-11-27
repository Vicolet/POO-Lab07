package calculator.implementations;

import calculator.operator.BinaryOperator;

/**
 * Represents the addition operator.
 * <p>
 * This operator takes two operands: the top value from the stack and the
 * current value. It computes their sum and updates the calculator's state
 * with the result.
 * </p>
 *
 * @author Léon Surbeck
 * @author Victor Nicolet
 * @date 20.11.2024
 */
public class Add extends BinaryOperator {

    /**
     * Performs the addition operation.
     * <p>
     * This method adds the left operand (retrieved from the stack)
     * and the right operand (current value). It returns the resulting sum.
     * </p>
     *
     * @param left the value retrieved from the stack
     * @param right the current value
     * @return the result of adding {@code left} and {@code right}
     */
    @Override
    protected double binaryOperation(double left, double right) {
        return left + right; // Perform addition
    }
}
