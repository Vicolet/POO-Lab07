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
     * Updates the calculator state by appending the digit to the current value.
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        String currentValueStr;

        // If a new entry is being started, replace the current value with the digit
        if (state.isNewEntry()) {
            currentValueStr = String.valueOf(digit);
            state.setNewEntry(false); // Disable "new entry" mode
        } else {
            // Append the digit to the current value
            currentValueStr = state.getCurrentValueAsString() + digit;
        }

        // Update the current value in the state
        state.setCurrentValueString(currentValueStr);
    }

    @Override
    protected double operation(double value) {
        return 0;
    }
}
