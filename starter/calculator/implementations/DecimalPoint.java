package calculator.implementations;

import calculator.operator.DefaultOperator;
import state.State;


/**
 * Represents the decimal point operator. This operator appends a decimal point
 * to the current value if it does not already contain one.
 */
public class DecimalPoint extends DefaultOperator {

    /**
     * Adds a decimal point to the current value if it does not already contain one.
     *
     * @param value the current value of the calculator (ignored for this operator)
     * @return the updated value with a decimal point appended
     */
    @Override
    protected double operation(double value) {
        return value; // The actual operation does not change the numeric value
    }

    /**
     * Executes the decimal point operation on the calculator's state.
     * Ensures the decimal point is appended to the current value without
     * affecting existing digits.
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        String currentValueStr = state.getCurrentValueAsString();

        // If the current value already contains a decimal point, do nothing
        if (currentValueStr.contains(".")) {
            return;
        }

        // If the current value is in "new entry" mode, replace it with "0."
        if (state.isNewEntry()) {
            state.setCurrentValueString("0.");
            state.setNewEntry(false); // Disable "new entry" mode
        } else {
            // Append the decimal point to the current value
            currentValueStr += ".";
            state.setCurrentValueString(currentValueStr);
        }
    }
}
