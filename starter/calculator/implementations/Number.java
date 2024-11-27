package calculator.implementations;

import calculator.operator.DefaultOperator;
import state.State;

/**
 * Represents a number input operator.
 * <p>
 * This operator processes the entry of a single digit into the current value and
 * updates the calculator's state accordingly.
 * </p>
 *
 * @author Léon Surbeck
 * @author Victor Nicolet
 * @date 20.11.2024
 */
public class Number extends DefaultOperator {
    private final int digit;

    /**
     * Constructs a Number operator for a specific digit.
     *
     * @param digit the digit to be processed
     */
    public Number(int digit) {
        this.digit = digit;
    }

    /**
     * Executes the number input operation on the calculator's state.
     * <p>
     * If a result is currently displayed, it is pushed onto the stack before
     * processing the new digit. Depending on the "new entry" mode, the digit
     * either replaces the current value or is appended to it.
     * </p>
     *
     * @param state the current state of the calculator
     */
    @Override
    public void performOperation(State state) {
        // Push the result into the stack if it is currently displayed
        if (state.isResultDisplayed()) {
            state.pushCurrentValue();       // Push the current value onto the stack
            state.setResultDisplayed(false); // Disable the result displayed flag
        }

        // If in "new entry" mode, replace the current value
        if (state.isNewEntry()) {
            state.setCurrentValue((double) digit); // Set the digit as the new value
            state.setNewEntry(false);             // Disable new entry mode
        } else {
            // Get the current value as a string
            String currentValueStr = state.getCurrentValueAsString();

            // Append or replace the digit in the current value string
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
