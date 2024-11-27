package calculator.implementations;

import calculator.operator.UnaryOperator;

/**
 * Represents the square operator (x^2).
 * <p>
 * This operator calculates the square of the current value
 * and updates the calculator's state.
 */
public class Square extends UnaryOperator {

    /**
     * Performs the square operation on the current value.
     *
     * @param value the current value of the calculator
     * @return the squared value of {@code value}
     */
    @Override
    protected double operation(double value) {
        return value * value; // Return the square of the value
    }
}
