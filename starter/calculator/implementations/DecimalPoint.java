package calculator.implementations;

import calculator.operator.DefaultOperator;
import state.State;

/**
 * Represents the decimal point operator.
 * <p>
 * Appends a decimal point to the current value if it doesn't already exist.
 */
public class DecimalPoint extends DefaultOperator {

    @Override
    protected boolean validate(State state) {
        // Ensure no duplicate decimal point
        return !state.getCurrentValueAsString().contains(".");
    }

    @Override
    protected void performOperation(State state) {
        String currentValueStr = state.getCurrentValueAsString();

        // Append a decimal point
        if (state.isNewEntry()) {
            state.setCurrentValueString("0.");
        } else {
            state.setCurrentValueString(currentValueStr + ".");
        }
    }
}
