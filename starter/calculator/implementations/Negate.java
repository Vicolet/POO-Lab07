package calculator.implementations;

import calculator.operator.UnaryOperator;
import state.State;

/**
 * Represents the negate operator, which changes the sign of the current value.
 * <p>
 * This operator negates the current value, making positive values negative
 * and vice versa.
 * </p>
 *
 * @author Léon Surbeck
 * @author Victor Nicolet
 * @date 20.11.2024
 */
public class Negate extends UnaryOperator {

    /**
     * Performs the negate operation on the current value.
     * <p>
     * Changes the sign of the input value.
     * </p>
     *
     * @param value the current value
     * @param state the current state of the calculator
     * @return the negated value of {@code value}
     */
    @Override
    protected double unaryOperation(double value, State state) {
        return -value; // Return the negated value
    }
}
