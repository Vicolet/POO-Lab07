package calculator.operator;

import state.State;

/**
 * Represents a unary operator that operates on a single operand.
 */
public abstract class UnaryOperator extends DefaultOperator {

    @Override
    public void execute(State state) {
        double currentValue = state.getCurrentValue();
        double result = operation(currentValue); // Perform unary operation
        assignResult(state, result);            // Assign result to state
    }

    /**
     * Assigns the result of the operation to the calculator state.
     *
     * @param state  the current state of the calculator
     * @param result the result of the operation
     */
    protected void assignResult(State state, double result) {
        state.setCurrentValue(result);
        state.setNewEntry(true);        // Prepare for a new entry
        state.setResultDisplayed(true); // Mark the result as displayed
    }
}
