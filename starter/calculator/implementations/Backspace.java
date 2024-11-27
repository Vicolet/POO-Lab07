package calculator.implementations;

import calculator.operator.DefaultOperator;
import state.State;

/**
 * Represents the backspace operator. Removes the last digit or character.
 */
public class Backspace extends DefaultOperator {
    @Override
    protected void performOperation(State state) {
        String currentValueStr = state.getCurrentValueAsString();

        // Remove the last character
        currentValueStr = currentValueStr.substring(0, currentValueStr.length() - 1);

        // If the resulting string is empty, reset to 0
        if (currentValueStr.isEmpty()) {
            state.setCurrentValue(0.0);
        } else {
            state.setCurrentValueString(currentValueStr);
        }
    }
}
