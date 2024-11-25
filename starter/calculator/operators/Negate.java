package calculator.operators;

import calculator.Operator;
import calculator.State;

/**
 * Represents the negate operator. This operator negates the current value
 * (changes its sign) and updates the calculator's state.
 */
public class Negate extends Operator {

    /**
     * Executes the negate operation on the calculator's state.
     * <p>
     * This operation changes the sign of the current value and updates the
     * calculator's state to indicate that a result is being displayed.
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        // Retrieve the current value
        double current = state.getCurrentValue();

        // Negate the current value
        double result = -current;

        // Update the state with the negated result
        state.setCurrentValue(result); // Set the negated value as the current value
        state.setNewEntry(true);       // Prepare the state for a new entry
        state.setResultDisplayed(true); // Indicate that a result is currently displayed
    }
}
