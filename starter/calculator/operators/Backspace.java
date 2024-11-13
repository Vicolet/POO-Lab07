package calculator.operators;

import calculator.Operator;
import calculator.State;

public class Backspace extends Operator {
    @Override
    public void execute(State state) {
        // Get the current value as a string
        String currentValueStr = state.getCurrentValue().toString();

        // if the current value is not a number, return
        if (currentValueStr.length() > 1) {
            // Delete the last character
            currentValueStr = currentValueStr.substring(0, currentValueStr.length() - 1);
        } else {
            // If the current value is a single digit, set it to 0
            currentValueStr = "0";
        }

        // Set the new current value
        state.setCurrentValue(Double.parseDouble(currentValueStr));
    }
}
