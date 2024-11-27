package calculator.implementations;

import calculator.operator.UnaryOperator;
import state.State;

/**
 * Represents the square root operator.
 * <p>
 * This operator calculates the square root of the current value and updates
 * the calculator's state. If the value is negative, it returns NaN to indicate
 * an invalid operation.
 * </p>
 *
 * @author Léon Surbeck
 * @author Victor Nicolet
 * @date 20.11.2024
 */
public class Sqrt extends UnaryOperator {

    /**
     * Performs the square root operation on the current value.
     * <p>
     * This method calculates the square root of the provided value. If the value
     * is negative, it returns NaN to indicate an error.
     * </p>
     *
     * @param value the current value of the calculator
     * @param state the current state of the calculator
     * @return the square root of the value, or NaN if the value is negative
     */
    @Override
    protected double unaryOperation(double value, State state) {
        if (value < 0) {
            return Double.NaN; // Return NaN for invalid square root
        }
        return Math.sqrt(value); // Calculate and return the square root
    }
}
