package calculator.implementations;

import calculator.operator.UnaryOperator;

/**
 * Represents the negate operator. This operator negates the current value
 * (changes its sign) and updates the calculator's state.
 * <p>
 * It inherits from UnaryOperator and operates only on the current value.
 */
public class Negate extends UnaryOperator {

    /**
     * Performs the negate operation on the current value.
     * <p>
     * This operation changes the sign of the current value, turning positive
     * values into negative and vice versa.
     *
     * @param value the current value of the calculator
     * @return the negated value
     */
    @Override
    protected double operation(double value) {
        return -value; // Change the sign of the value
    }
}
