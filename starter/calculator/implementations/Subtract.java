package calculator.implementations;

import calculator.operator.BinaryOperator;

/**
 * Represents the subtraction operator.
 */
public class Subtract extends BinaryOperator {

    /**
     * Performs the subtraction operation.
     *
     * @param left  the left operand
     * @param right the right operand
     * @return the result of subtracting {@code right} from {@code left}
     */
    @Override
    protected double binaryOperation(double left, double right) {
        return left - right; // Specific logic for subtraction
    }
}
