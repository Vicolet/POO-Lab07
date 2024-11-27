package calculator.implementations;

import calculator.operator.BinaryOperator;

/**
 * Represents the multiplication operator. This operator retrieves the top value
 * from the stack, multiplies it by the current value, and updates the calculator's
 * state with the result.
 */
public class Multiply extends BinaryOperator {

    /**
     * Constructor for Multiply operator.
     */
    public Multiply() {
        super();
    }

    /**
     * Performs the multiplication operation.
     *
     * @param left  the left operand (value from the stack)
     * @param right the right operand (current value)
     * @return the result of multiplying left by right
     */
    @Override
    protected double operation(double left, double right) {
        return left * right;
    }

    @Override
    protected double operation(double value) {
        return 0;
    }
}
