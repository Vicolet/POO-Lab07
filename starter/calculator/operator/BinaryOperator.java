package calculator.operator;

import state.State;

/**
 * Abstract base class for binary operators.
 */
public abstract class BinaryOperator extends DefaultOperator {

    /**
     * Executes the binary operation on the calculator's state.
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        // Check if the stack is empty
        if (state.getStack().isEmpty()) {
            state.setError("Error: Empty stack");
            return;
        }

        double left = state.pop(); // Get the value from the stack
        double right = state.getCurrentValue(); // Get the current value

        // Perform the operation
        double result = operation(left, right);

        if (Double.isNaN(result)) {
            state.setError("Error: Invalid operation");
        } else {
            state.setCurrentValue(result);
            state.setNewEntry(true);
            state.setResultDisplayed(true);
        }
    }

    /**
     * Performs the specific binary operation.
     *
     * @param left  the left operand (value from the stack)
     * @param right the right operand (current value)
     * @return the result of the operation
     */
    protected abstract double operation(double left, double right);
}
