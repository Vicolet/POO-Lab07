package calculator.implementations;

import calculator.operator.UnaryOperator;
import state.State;


/**
 * Represents the negate operator, which negates the current value by changing its sign.
 */
public class Negate extends UnaryOperator {

    /**
     * Performs the negate operation on the current value.
     *
     * @param value the current value
     * @return the negated value
     */
    @Override
    protected double unaryOperation(double value, State state) {
        return -value;
    }
}
