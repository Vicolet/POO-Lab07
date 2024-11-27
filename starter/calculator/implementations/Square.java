package calculator.implementations;

import calculator.operator.UnaryOperator;
import state.State;

/**
 * Represents the square operator (x^2).
 * <p>
 * This operator calculates the square of the current value and updates the
 * calculator's state with the result.
 * </p>
 *
 * @author Léon Surbeck
 * @author Victor Nicolet
 * @date 20.11.2024
 */
public class Square extends UnaryOperator {

    /**
     * Performs the square operation on the current value.
     * <p>
     * This method calculates the square of the given value and returns the result.
     * </p>
     *
     * @param value the current value of the calculator
     * @param state the current state of the calculator
     * @return the squared value of {@code value}
     */
    @Override
    protected double unaryOperation(double value, State state) {
        return value * value; // Calculate and return the square of the value
    }
}
