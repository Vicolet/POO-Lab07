package calculator.operators;

import calculator.Operator;
import calculator.State;

public class Enter extends Operator {
    @Override
    public void execute(State state) {
        state.pushCurrentValue();
    }
}
