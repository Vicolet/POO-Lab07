package calculator.implementations;

import calculator.operator.DivisionBase;

/**
 * Represents the division operator.
 */
public class Divide extends DivisionBase {

    /**
     * Implements the basic division logic.
     *
     * @param left  the numerator
     * @param right the denominator
     * @return the result of dividing {@code left} by {@code right}
     */
    @Override
    protected double divide(double left, double right) {
        return left / right;
    }

    @Override
    protected double operation(double value) {
        return 0;
    }
}
