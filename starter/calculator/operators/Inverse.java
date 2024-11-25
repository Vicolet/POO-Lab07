package calculator.operators;

import calculator.Operator;
import calculator.State;

/**
 * Represents the inverse operator. This operator calculates the reciprocal
 * (1/current value) of the current value and updates the calculator's state.
 */
public class Inverse extends Operator {

    /**
     * Executes the inverse operation on the calculator's state.
     * <p>
     * If the current value is zero, an error message is set to prevent division by zero.
     * Otherwise, the reciprocal of the current value is calculated and stored as the
     * new current value. The state is updated to indicate that a result is being displayed.
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        // Retrieve the current value
        double current = state.getCurrentValue();

        // Prevent division by zero
        if (current == 0) {
            state.setError("Error: Division by zero"); // Set an error message
            return;
        }

        // Perform the inversion
        double result = 1 / current;

        // Update the state with the result
        state.setCurrentValue(result); // Set the result as the current value
        state.setNewEntry(true);       // Prepare the state for a new entry
        state.setResultDisplayed(true); // Indicate that a result is currently displayed
    }
}
