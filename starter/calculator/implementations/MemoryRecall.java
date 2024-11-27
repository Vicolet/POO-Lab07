package calculator.implementations;

import calculator.operator.Operator;
import state.State;

/**
 * Represents the memory recall operator. This operator retrieves the value
 * stored in memory and sets it as the current value in the calculator's state.
 */
public class MemoryRecall extends Operator {

    /**
     * Executes the memory recall operation on the calculator's state.
     * <p>
     * This operation sets the current value to the value stored in memory.
     * If no value is stored in memory, the current value is set to 0.
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        state.setCurrentValue(state.recallFromMemory()); // Recall value from memory
    }
}
