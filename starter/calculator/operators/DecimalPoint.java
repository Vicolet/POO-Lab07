package calculator.operators;

import calculator.Operator;
import calculator.State;

public class DecimalPoint extends Operator {
    @Override
    public void execute(State state) {
        String currentValueStr = state.getCurrentValue().toString();
        if (!currentValueStr.contains(".")) {  // Verify if the current value already contains a decimal point
            currentValueStr += ".";  // Add a decimal point to the current value
            state.setCurrentValue(Double.parseDouble(currentValueStr));
        }
    }
}
