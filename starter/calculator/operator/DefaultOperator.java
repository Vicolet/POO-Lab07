package calculator.operator;

import state.State;

/**
 * Represents a default operator for basic operations.
 */
public abstract class DefaultOperator extends Operator {

    /**
     * Executes the default operation.
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        double currentValue = state.getCurrentValue();
        double result = operation(currentValue); // Perform the operation
        state.setCurrentValue(result);
        state.setNewEntry(true);        // Prepare for a new entry
        state.setResultDisplayed(true); // Mark the result as displayed
    }

    /**
     * Performs a basic operation on the current value.
     *
     * @param value the current value
     * @return the result of the operation
     */
    protected abstract double operation(double value);
}
