package calculator.implementations;

import calculator.operator.BinaryOperator;

/**
 * Represents the subtraction operator.
 * <p>
 * This operator retrieves the top value from the stack, subtracts the current value
 * from it, and updates the calculator's state with the result.
 * </p>
 *
 * @author Léon Surbeck
 * @author Victor Nicolet
 * @date 20.11.2024
 */
public class Subtract extends BinaryOperator {

    /**
     * Performs the subtraction operation.
     * <p>
     * This method calculates the difference between two operands: the top value from
     * the stack and the current value.
     * </p>
     *
     * @param left  the value from the stack
     * @param right the current value
     * @return the result of subtracting {@code right} from {@code left}
     */
    @Override
    protected double binaryOperation(double left, double right) {
        return left - right; // Calculate the difference
    }
}
