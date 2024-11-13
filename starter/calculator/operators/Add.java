package calculator.operators;

import calculator.Operator;
import calculator.State;

public class Add extends Operator {
    public void execute(State state) {
        double b = state.pop();
        double a = state.pop();
        state.push(a + b);
    }
}