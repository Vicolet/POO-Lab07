package calculator.operators;

import calculator.Operator;
import calculator.State;

public class Add extends Operator {
    @Override
    public void execute(State state) {
        double b = state.pop();
        double a = state.pop();
        state.setCurrentValue(a + b);
        state.pushCurrentValue();
    }
}
