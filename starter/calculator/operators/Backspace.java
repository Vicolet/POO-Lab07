package calculator.operators;

import calculator.Operator;
import calculator.State;

/**
 * Represents the backspace operation. This operator removes the last digit
 * or character from the current value. If the current value becomes empty
 * or invalid, it resets to 0.
 */
public class Backspace extends Operator {

    /**
     * Executes the backspace operation on the calculator's state.
     * <p>
     * If the calculator is in "new entry" mode, the value is reset to 0 and
     * remains in "new entry" mode. Otherwise, the last character of the
     * current value is removed. If the resulting value is empty, it is reset
     * to 0.
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        // Handle "new entry" mode by resetting the current value to 0
        if (state.isNewEntry()) {
            state.setCurrentValue(0.0);
            state.setNewEntry(true); // Remain in "new entry" mode
            return;
        }

        // Get the current value as a string
        String currentValueStr = state.getCurrentValueAsString();

        // If the current value is "0" or empty, reset it to 0
        if (currentValueStr.equals("0") || currentValueStr.isEmpty()) {
            state.setCurrentValue(0.0);
            state.setNewEntry(true); // Remain in "new entry" mode
            return;
        }

        // Remove the last character from the current value
        currentValueStr = currentValueStr.substring(0, currentValueStr.length() - 1);

        // If the resulting string is empty, reset the current value to 0
        if (currentValueStr.isEmpty()) {
            state.setCurrentValue(0.0);
            state.setNewEntry(true); // Prepare for a new value
        } else {
            // Update the current value with the modified string
            state.setCurrentValue(Double.parseDouble(currentValueStr));
        }
    }
}
