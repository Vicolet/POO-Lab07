package calculator.operators;

import calculator.Operator;
import calculator.State;

/**
 * Represents the division operator. This operator retrieves the top value
 * from the stack, divides it by the current value, and updates the calculator's
 * state with the result.
 */
public class Divide extends Operator {

    /**
     * Executes the division operation on the calculator's state.
     * <p>
     * If the stack is empty, an error message is set. If the current value is zero,
     * an error message is also set to prevent division by zero. Otherwise, the top value
     * of the stack is divided by the current value, and the result is stored as the
     * new current value. The state is updated to indicate that a result is being displayed.
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

        // Prevent division by zero
        if (current == 0) {
            state.setError("Error: Division by zero"); // Set an error message
            return;
        }

        // Perform the division
        double result = stackTop / current;

        // Update the state with the result
        state.setCurrentValue(result); // Set the result as the current value
        state.setNewEntry(true);       // Prepare the state for a new entry
        state.setResultDisplayed(true); // Indicate that a result is currently displayed
    }
}
