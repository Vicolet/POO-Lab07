package calculator.operators;

import calculator.Operator;
import calculator.State;

/**
 * Represents the multiplication operator. This operator retrieves the top value
 * from the stack, multiplies it by the current value, and updates the calculator's
 * state with the result.
 */
public class Multiply extends Operator {

    /**
     * Executes the multiplication operation on the calculator's state.
     * <p>
     * If the stack is empty, an error message is set. Otherwise, the top value
     * of the stack is retrieved and multiplied by the current value. The result
     * is stored as the new current value, and the state is updated to indicate
     * that a result is being displayed.
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

        // Perform the multiplication
        double result = stackTop * current;

        // Update the state with the result
        state.setCurrentValue(result); // Set the result as the current value
        state.setNewEntry(true);       // Prepare the state for a new entry
        state.setResultDisplayed(true); // Indicate that a result is currently displayed
    }
}
