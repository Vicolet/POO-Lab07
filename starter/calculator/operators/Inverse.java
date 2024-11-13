package calculator.operators;

import calculator.Operator;
import calculator.State;

public class Inverse extends Operator {
    @Override
    public void execute(State state) {
        double value = state.getCurrentValue();
        if (value == 0) {
            state.setError("Division by zero");
        } else {
            state.setCurrentValue(1 / value);
        }
    }
}
