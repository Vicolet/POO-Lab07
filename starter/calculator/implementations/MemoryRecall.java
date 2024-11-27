package calculator.implementations;

import calculator.operator.Operator;
import state.State;

/**
 * Represents the memory recall operator.
 * <p>
 * This operator retrieves the value stored in memory and sets it as the current
 * value in the calculator's state. If no value is stored in memory, the current
 * value is set to 0.
 * </p>
 *
 * @author Léon Surbeck
 * @author Victor Nicolet
 * @date 20.11.2024
 */
public class MemoryRecall extends Operator {

    /**
     * Executes the memory recall operation on the calculator's state.
     * <p>
     * This operation retrieves the value stored in memory and updates the
     * calculator's current value. If no value is stored in memory, the current
     * value defaults to 0.
     * </p>
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        state.setCurrentValue(state.recallFromMemory()); // Recall value from memory
    }
}
