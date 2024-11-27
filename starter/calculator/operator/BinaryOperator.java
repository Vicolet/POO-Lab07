package calculator.operator;

import state.State;

/**
 * Represents a binary operator that operates on two operands.
 */
public abstract class BinaryOperator extends UnaryOperator {

    @Override
    public void execute(State state) {
        if (state.getStack().isEmpty()) {
            state.setError("Error: Stack is empty");
            return;
        }

        double stackTop = state.pop();        // Retrieve the top value from the stack
        double currentValue = state.getCurrentValue();
        double result = operation(stackTop, currentValue); // Perform binary operation
        assignResult(state, result);                     // Assign result to state
    }

    /**
     * Performs a binary operation on two operands.
     *
     * @param left  the first operand (from the stack)
     * @param right the second operand (current value)
     * @return the result of the operation
     */
    protected abstract double operation(double left, double right);
}
