package calculator.operator;

import state.State;

/**
 * Represents the base class for unary operators.
 * <p>
 * Unary operators perform operations on the current value of the calculator.
 * Derived classes must implement the {@code unaryOperation} method to define
 * the specific operation.
 */
public abstract class UnaryOperator extends DefaultOperator {

    /**
     * Performs the unary operation on the current value of the calculator.
     *
     * @param state the current state of the calculator
     */
    @Override
    protected void performOperation(State state) {
        double current = state.getCurrentValue();
        double result = unaryOperation(current, state); // Perform the unary operation
        state.setCurrentValue(result); // Update the state with the result
        state.setResultDisplayed(true);
    }

    /**
     * Abstract method to define the specific unary operation.
     *
     * @param value the current value of the calculator
     * @param state the current state of the calculator
     * @return the result of the unary operation
     */
    protected abstract double unaryOperation(double value, State state);
}
