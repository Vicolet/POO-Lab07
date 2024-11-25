package calculator.operators;

import calculator.Operator;
import calculator.State;

/**
 * Represents the square root operator. This operator calculates the square
 * root of the current value and updates the calculator's state.
 */
public class Sqrt extends Operator {

    /**
     * Executes the square root operation on the calculator's state.
     * <p>
     * If the current value is negative, an error message is set to indicate
     * that the operation is invalid. Otherwise, the square root of the current
     * value is calculated and stored as the new current value. The state is
     * updated to indicate that a result is being displayed.
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        // Retrieve the current value
        double current = state.getCurrentValue();

        // Handle square root of a negative number
        if (current < 0) {
            state.setError("Error: Square root of a negative number"); // Set an error message
            return;
        }

        // Calculate the square root
        double result = Math.sqrt(current);

        // Update the state with the result
        state.setCurrentValue(result); // Set the result as the current value
        state.setNewEntry(true);       // Prepare the state for a new entry
        state.setResultDisplayed(true); // Indicate that a result is currently displayed
    }
}
