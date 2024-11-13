package calculator.operators;

import calculator.Operator;
import calculator.State;

public class Square extends Operator {
    @Override
    public void execute(State state) {
        double value = state.getCurrentValue();
        state.setCurrentValue(value * value);
    }
}
