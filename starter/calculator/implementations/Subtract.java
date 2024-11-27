package calculator.implementations;

import calculator.operator.BinaryOperator;

/**
 * Represents the subtraction operator. This operator retrieves the top value
 * from the stack, subtracts the current value from it, and updates the calculator's
 * state with the result.
 */
public class Subtract extends BinaryOperator {

    /**
     * Performs the subtraction operation on the given operands.
     *
     * @param left  the left operand (value from the stack)
     * @param right the right operand (current value)
     * @return the result of subtracting {@code right} from {@code left}
     */
    @Override
    protected double operation(double left, double right) {
        return left - right; // Perform the subtraction
    }

    @Override
    protected double operation(double value) {
        return 0;
    }
}
