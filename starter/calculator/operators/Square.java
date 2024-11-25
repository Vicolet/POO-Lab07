package calculator.operators;

import calculator.Operator;
import calculator.State;

/**
 * Represents the square operator. This operator calculates the square
 * of the current value and updates the calculator's state.
 */
public class Square extends Operator {

    /**
     * Executes the square operation on the calculator's state.
     * <p>
     * This operation squares the current value and stores the result as
     * the new current value. The state is updated to indicate that a result
     * is being displayed.
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        // Retrieve the current value
        double current = state.getCurrentValue();

        // Calculate the square of the current value
        double result = current * current;

        // Update the state with the result
        state.setCurrentValue(result); // Set the squared result as the current value
        state.setNewEntry(true);       // Prepare the state for a new entry
        state.setResultDisplayed(true); // Indicate that a result is currently displayed
    }
}
