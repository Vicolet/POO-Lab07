package calculator.implementations;

import calculator.operator.UnaryOperator;
import state.State;

/**
 * Represents the decimal point operator. This operator appends a decimal point
 * to the current value if it does not already contain one.
 */
public class DecimalPoint extends UnaryOperator {

    /**
     * Constructor for DecimalPoint operator.
     */
    public DecimalPoint() {
        super(); // Call to UnaryOperator's constructor if needed
    }

    @Override
    protected double operation(double value) {
        // Convert the current value to a string
        String currentValueStr = String.valueOf(value);

        // If the value is already an integer (no decimal point), add "."
        if (!currentValueStr.contains(".")) {
            currentValueStr += "."; // Append the decimal point
        }

        // Return the updated value as a double
        return Double.parseDouble(currentValueStr);
    }

    @Override
    public void execute(State state) {
        // If a result is currently displayed, reset for new input
        if (state.isResultDisplayed()) {
            state.setCurrentValue(0.0);      // Reset to 0
            state.setResultDisplayed(false); // Clear result displayed flag
            state.setNewEntry(false);       // Prepare for new input
        }

        // Perform the decimal point operation using the overridden method
        double result = operation(state.getCurrentValue());
        state.setCurrentValue(result);
        state.setNewEntry(false); // Disable new entry mode
    }
}
