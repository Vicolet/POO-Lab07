package calculator.implementations;

import calculator.operator.DivisionBase;
import state.State;

/**
 * Represents the inverse operator. This operator calculates 1 / current value.
 */
public class Inverse extends DivisionBase {

    protected double getLeftOperand(State state) {
        return 1.0; // Inverse always divides 1 by the current value
    }

    @Override
    protected double operation(double value) {
        return 0;
    }
}
