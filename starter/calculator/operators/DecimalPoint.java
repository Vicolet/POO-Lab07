package calculator.operators;

import calculator.Operator;
import calculator.State;

/**
 * Represents the decimal point operator. This operator appends a decimal point
 * to the current value if it does not already contain one.
 */
public class DecimalPoint extends Operator {

    /**
     * Executes the decimal point operation on the calculator's state.
     * <p>
     * If a result is currently displayed, the current value is reset to 0
     * before appending the decimal point. The operation ensures that only
     * one decimal point can exist in the current value.
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        // If a result is displayed, reset the current value for a new entry
        if (state.isResultDisplayed()) {
            state.setCurrentValue(0.0);     // Reset to 0
            state.setResultDisplayed(false); // Clear result displayed flag
            state.setNewEntry(false);      // Prepare for new input
        }

        // Get the current value as a string
        String currentValueStr = state.getCurrentValueAsString();

        // Append a decimal point if not already present
        if (!currentValueStr.contains(".")) {
            currentValueStr += "."; // Add a decimal point
            state.setCurrentValueString(currentValueStr); // Update as a temporary string
        }

        // Disable new entry mode
        state.setNewEntry(false);
    }
}
