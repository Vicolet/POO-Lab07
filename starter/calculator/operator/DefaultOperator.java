package calculator.operator;

import state.State;

/**
 * Represents the base class for all default operators.
 * <p>
 * This class provides a framework for validating and executing operations on
 * the calculator's state.
 */
public abstract class DefaultOperator extends Operator {

    /**
     * Executes the operation, with validation and error handling.
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        if (!validate(state)) {
            return; // Abort execution if validation fails
        }
        performOperation(state);
        // state.setNewEntry(true);
        state.setResultDisplayed(true);
    }

    /**
     * Validates the state before performing the operation.
     * <p>
     * Derived classes can override this method to add custom validation.
     *
     * @param state the current state of the calculator
     * @return {@code true} if the operation is valid, {@code false} otherwise
     */
    protected boolean validate(State state) {
        return true; // Default implementation assumes no validation needed
    }

    /**
     * Performs the specific operation on the calculator's state.
     * <p>
     * This method should be implemented by derived classes to define the
     * behavior of the operator.
     *
     * @param state the current state of the calculator
     */
    protected abstract void performOperation(State state);
}
