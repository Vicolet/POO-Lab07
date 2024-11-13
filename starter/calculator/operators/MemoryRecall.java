package calculator.operators;

import calculator.Operator;
import calculator.State;

public class MemoryRecall extends Operator {
    @Override
    public void execute(State state) {
        state.setCurrentValue(state.recallFromMemory());
    }
}
