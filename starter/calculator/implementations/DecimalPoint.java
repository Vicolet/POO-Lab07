package calculator.implementations;

import calculator.operator.DefaultOperator;
import state.State;

/**
 * Represents the decimal point operator.
 * <p>
 * This operator appends a decimal point to the current value if it does not already contain one.
 * If the calculator is in "new entry" mode, it replaces the current value with "0." and prepares
 * the state for further input.
 * </p>
 *
 * @author Léon Surbeck
 * @author Victor Nicolet
 * @date 20.11.2024
 */
public class DecimalPoint extends DefaultOperator {

    /**
     * Appends a decimal point to the current value in the calculator's state.
     * <p>
     * If the current value already contains a decimal point, no changes are made.
     * If the calculator is in "new entry" mode, the current value is replaced with "0."
     * and the state is prepared for additional input.
     * </p>
     *
     * @param state the current state of the calculator
     */
    @Override
    protected void performOperation(State state) {
        String currentValueStr = state.getCurrentValueAsString();

        if (!currentValueStr.contains(".")) {
            if (state.isNewEntry()) {
                state.setCurrentValueString("0."); // Start new entry with "0."
                state.setNewEntry(false);         // Disable "new entry" mode
            } else {
                state.setCurrentValueString(currentValueStr + "."); // Append decimal point
            }
        }
    }
}
