package calculator.implementations;

import calculator.operator.UnaryOperator;
import state.State;

/**
 * Represents the square root operator. This operator calculates the square root
 * of the current value and updates the calculator's state.
 */
public class Sqrt extends UnaryOperator {

    /**
     * Performs the square root operation on the current value.
     *
     * @param value the current value of the calculator
     * @return the square root of the value, or NaN if the value is negative
     */
    @Override
    protected double unaryOperation(double value, State state) {
        if (value < 0) {
            return Double.NaN; // Return NaN for invalid square root
        }
        return Math.sqrt(value);
    }
}
