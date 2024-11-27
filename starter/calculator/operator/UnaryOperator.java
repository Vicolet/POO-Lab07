package calculator.operator;

import state.State;

/**
 * Represents the base class for unary operators.
 * <p>
 * Unary operators perform operations on the current value of the calculator.
 * Derived classes must implement the {@code unaryOperation} method to define
 * the specific operation.
 * </p>
 *
 * @author Léon Surbeck
 * @author Victor Nicolet
 * @date 20.11.2024
 */
public abstract class UnaryOperator extends DefaultOperator {

    /**
     * Performs the unary operation on the current value of the calculator.
     * <p>
     * This method retrieves the current value, applies the specific unary operation,
     * and updates the calculator's state with the result. Additionally, it sets the
     * result displayed flag to true.
     * </p>
     *
     * @param state the current state of the calculator
     */
    @Override
    protected void performOperation(State state) {

        double current = state.getCurrentValue();
        double result = unaryOperation(current, state); // Perform the unary operation
        if (Double.isNaN(result)) {
            state.setError("Error");
            state.setNewEntry(true);
            state.setResultDisplayed(false);
            return;
        }
        state.setCurrentValue(result); // Update the state with the result
        state.setResultDisplayed(true);
    }

    /**
     * Abstract method to define the specific unary operation.
     * <p>
     * Subclasses must implement this method to perform a specific transformation
     * on the current value.
     * </p>
     *
     * @param value the current value of the calculator
     * @param state the current state of the calculator
     * @return the result of the unary operation
     */
    protected abstract double unaryOperation(double value, State state);
}
