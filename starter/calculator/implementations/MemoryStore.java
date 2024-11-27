package calculator.implementations;

import calculator.operator.Operator;
import state.State;

/**
 * Represents the memory store operator. This operator stores the current value
 * in the calculator's memory.
 */
public class MemoryStore extends Operator {

    /**
     * Executes the memory store operation on the calculator's state.
     * <p>
     * This operation saves the current value into the calculator's memory.
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        state.storeInMemory(); // Store the current value in memory
    }
}
