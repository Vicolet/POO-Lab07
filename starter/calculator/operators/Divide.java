package calculator.operators;

import calculator.Operator;
import calculator.State;

public class Divide extends Operator {
    @Override
    public void execute(State state) {
        double b = state.pop();
        double a = state.pop();
        if (b == 0) {
            state.setError("Division by zero");
        } else {
            state.setCurrentValue(a / b);
            state.pushCurrentValue();
        }
    }
}
