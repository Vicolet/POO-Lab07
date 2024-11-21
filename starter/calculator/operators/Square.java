package calculator.operators;

import calculator.Operator;
import calculator.State;

public class Square extends Operator {
    @Override
    public void execute(State state) {
        double current = state.getCurrentValue();

        double result = current * current;

        state.setCurrentValue(result);
        state.setNewEntry(true);
        state.setResultDisplayed(true);
    }
}
