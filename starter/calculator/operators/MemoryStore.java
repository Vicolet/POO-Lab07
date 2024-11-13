package calculator.operators;

import calculator.Operator;
import calculator.State;

public class MemoryStore extends Operator {
    @Override
    public void execute(State state) {
        state.storeInMemory();
    }
}
