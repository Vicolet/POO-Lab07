package calculator.implementations;

import calculator.operator.DefaultOperator;
import state.State;

/**
 * Represents the enter operator.
 * <p>
 * This operator pushes the current value of the calculator onto the stack,
 * resets the current value to zero, and prepares the calculator's state
 * for a new entry.
 * </p>
 *
 * @author Léon Surbeck
 * @author Victor Nicolet
 * @date 20.11.2024
 */
public class Enter extends DefaultOperator {

    /**
     * Executes the "enter" operation on the calculator's state.
     * <p>
     * This method pushes the current value onto the stack and resets the
     * current value to zero. It does not perform any arithmetic or unary
     * operation.
     * </p>
     *
     * @param state the current state of the calculator
     */
    @Override
    protected void performOperation(State state) {
        state.pushCurrentValue();   // Push the current value onto the stack
        state.setCurrentValue(0.0); // Reset the current value to 0
    }
}
