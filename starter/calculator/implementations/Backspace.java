package calculator.implementations;

import calculator.operator.DefaultOperator;
import state.State;

/**
 * Represents the backspace operator.
 * <p>
 * This operator removes the last digit or character from the current value
 * in the calculator's state. If the resulting value becomes empty or invalid,
 * it resets to 0.
 * </p>
 *
 * @author Léon Surbeck
 * @author Victor Nicolet
 * @date 20.11.2024
 */
public class Backspace extends DefaultOperator {

    /**
     * Performs the backspace operation.
     * <p>
     * Removes the last character from the current value. If the resulting value
     * is empty, it resets the value to 0.
     * </p>
     *
     * @param state the current state of the calculator
     */
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
