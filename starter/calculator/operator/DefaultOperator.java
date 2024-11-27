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
        performOperation(state);
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
