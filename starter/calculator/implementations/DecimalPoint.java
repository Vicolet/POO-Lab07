package calculator.implementations;

import calculator.operator.DefaultOperator;
import state.State;

/**
 * Represents the decimal point operator. This operator appends a decimal point
 * to the current value if it does not already contain one.
 */
public class DecimalPoint extends DefaultOperator {

    @Override
    protected void performOperation(State state) {
        String currentValueStr = state.getCurrentValueAsString();

        if (!currentValueStr.contains(".")) {
            if (state.isNewEntry()) {
                state.setCurrentValueString("0.");
                state.setNewEntry(false);
            } else {
                state.setCurrentValueString(currentValueStr + ".");
            }
        }
    }
}
