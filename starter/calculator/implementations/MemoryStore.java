package calculator.implementations;

import calculator.operator.Operator;
import state.State;

/**
 * Represents the memory store operator.
 * <p>
 * This operator saves the current value of the calculator into memory,
 * allowing it to be recalled later using the {@link MemoryRecall} operator.
 * </p>
 *
 * @author Léon Surbeck
 * @author Victor Nicolet
 * @date 20.11.2024
 */
public class MemoryStore extends Operator {

    /**
     * Executes the memory store operation on the calculator's state.
     * <p>
     * This operation stores the current value of the calculator in memory,
     * replacing any previously stored value.
     * </p>
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        state.storeInMemory(); // Store the current value in memory
    }
}
