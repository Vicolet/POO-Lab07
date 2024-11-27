package calculator.operator;

import state.State;

/**
 * Represents the base class for all default operators.
 * <p>
 * This class provides a framework for executing operations on the calculator's state.
 * Derived classes must implement the {@code performOperation} method to define the specific behavior.
 * </p>
 *
 * @author Léon Surbeck
 * @author Victor Nicolet
 * @date 20.11.2024
 */
public abstract class DefaultOperator extends Operator {

    /**
     * Executes the operation, delegating the logic to {@code performOperation}.
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        performOperation(state);
    }

    /**
     * Abstract method to perform the specific operation on the calculator's state.
     * <p>
     * Derived classes must implement this method to define the behavior of the operator.
     * </p>
     *
     * @param state the current state of the calculator
     */
    protected abstract void performOperation(State state);
}
