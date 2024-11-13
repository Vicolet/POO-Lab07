package calculator.operators;

import calculator.Operator;
import calculator.State;

public class Sqrt extends Operator {
    @Override
    public void execute(State state) {
        double value = state.getCurrentValue();
        if (value < 0) {
            state.setError("Square root of a negative number");
        } else {
            state.setCurrentValue(Math.sqrt(value));
        }
    }
}
