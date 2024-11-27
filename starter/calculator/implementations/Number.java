package calculator.implementations;

import calculator.operator.DefaultOperator;

/**
 * Represents a number operator for entering digits.
 * <p>
 * This operator updates the current value of the calculator by appending
 * the entered digit.
 */
public class Number extends DefaultOperator {

    private final double digit;

    /**
     * Constructs a Number operator with the specified digit.
     *
     * @param digit the digit to be entered
     */
    public Number(double digit) {
        this.digit = digit;
    }

    /**
     * Performs the operation to set the current value to the specified digit.
     *
     * @param value the current value of the calculator (ignored in this case)
     * @return the digit to be set as the new current value
     */
    @Override
    protected double operation(double value) {
        return digit; // Set the current value to the digit
    }
}
