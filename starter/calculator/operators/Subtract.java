package calculator.operators;

import calculator.Operator;
import calculator.State;

/**
 * Represents the subtraction operator. This operator retrieves the top value
 * from the stack, subtracts the current value from it, and updates the calculator's
 * state with the result.
 */
public class Subtract extends Operator {

    /**
     * Executes the subtraction operation on the calculator's state.
     * <p>
     * If the stack is empty, an error message is set. Otherwise, the top value
     * of the stack is retrieved, and the current value is subtracted from it.
     * The result is stored as the new current value, and the state is updated
     * to indicate that a result is being displayed.
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        // Check if the stack is empty
        if (state.getStack().isEmpty()) {
            state.setError("Error: Empty stack"); // Set an error message
            return;
        }

        // Retrieve necessary values
        double stackTop = state.pop(); // Retrieve the top value of the stack
        double current = state.getCurrentValue(); // Retrieve the current value

        // Perform the subtraction
        double result = stackTop - current;

        // Update the state with the result
        state.setCurrentValue(result); // Set the result as the current value
        state.setNewEntry(true);       // Prepare the state for a new entry
        state.setResultDisplayed(true); // Indicate that a result is currently displayed
    }
}
