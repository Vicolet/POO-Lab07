package calculator.implementations;

import calculator.operator.UnaryOperator;

/**
 * Represents the square root operator. This operator calculates the square root
 * of the current value and updates the calculator's state.
 * <p>
 * It inherits from UnaryOperator and operates only on the current value.
 */
public class Sqrt extends UnaryOperator {

    /**
     * Performs the square root operation on the current value.
     * <p>
     * If the current value is negative, an ArithmeticException is thrown
     * to indicate that the operation is invalid.
     *
     * @param value the current value of the calculator
     * @return the square root of the value
     * @throws ArithmeticException if the value is negative
     */
    @Override
    protected double operation(double value) {
        if (value < 0) {
            throw new ArithmeticException("Error: Square root of a negative number");
        }
        return Math.sqrt(value); // Calculate and return the square root
    }
}
