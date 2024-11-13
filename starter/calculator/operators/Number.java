package calculator.operators;

import calculator.Operator;
import calculator.State;

public class Number extends Operator {
    private final int digit;

    public Number(int digit) {
        this.digit = digit;
    }

    @Override
    public void execute(State state) {
        // Convert the current value to a string
        String currentValueStr = state.getCurrentValue().toString();

        // if the current value is 0, replace it with the digit
        if (currentValueStr.equals("0")) {
            currentValueStr = Integer.toString(digit);
        } else {
            // Otherwise, append the digit to the current value
            currentValueStr += digit;
        }

        // Set the current value to the new value
        state.setCurrentValue(Double.parseDouble(currentValueStr));
    }
}
