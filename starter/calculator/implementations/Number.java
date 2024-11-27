package calculator.implementations;

import calculator.operator.DefaultOperator;
import state.State;

/**
 * Represents a number operator for entering digits.
 * <p>
 * This operator updates the current value of the calculator by appending
 * the entered digit to the existing value.
 */
public class Number extends DefaultOperator {

    private final int digit;

    /**
     * Constructs a Number operator with the specified digit.
     *
     * @param digit the digit to be entered
     */
    public Number(int digit) {
        this.digit = digit;
    }

    /**
     * Appends the digit to the current value in the calculator's state.
     *
     * @param state the current state of the calculator
     */
    @Override
    protected void performOperation(State state) {
        String currentValueStr;

        // Replace the current value if in "new entry" mode
        if (state.isNewEntry()) {
            state.setCurrentValue((double) digit); // Set the digit as the new value
            state.setNewEntry(false);             // Disable new entry mode
        } else {
            // Get the current value as a string
            currentValueStr = state.getCurrentValueAsString();

            // Append the digit to the current value string
            if (currentValueStr.equals("0")) {
                currentValueStr = Integer.toString(digit); // Replace "0" with the digit
            } else {
                currentValueStr += digit; // Append the digit
            }

            // Update the current value
            state.setCurrentValue(Double.parseDouble(currentValueStr));
        }
    }

}
