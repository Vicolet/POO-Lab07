package calculator.operator;

import state.State;

/**
 * Abstract base class for all calculator operators.
 * <p>
 * This class provides the structure for implementing various types of operations
 * that manipulate the calculator's state. Subclasses are expected to define
 * the specific behavior of the operation by overriding the {@code execute} method.
 */
public abstract class Operator {

    /**
     * Executes the operation on the given calculator state.
     * <p>
     * Subclasses must implement this method to perform the specific logic
     * of the operator and update the calculator's state accordingly.
     *
     * @param state the current state of the calculator
     */
    public abstract void execute(State state);
}
