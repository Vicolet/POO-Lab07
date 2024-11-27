package calculator.implementations;

import calculator.operator.Operator;
import state.State;

/**
 * Represents the clear error operator.
 * <p>
 * This operator resets the current value to 0, clears any existing error messages,
 * disables decimal mode, and prepares the calculator's state for a new entry.
 * </p>
 *
 * @author Léon Surbeck
 * @author Victor Nicolet
 * @date 20.11.2024
 */
public class ClearError extends Operator {

    /**
     * Executes the clear error operation on the calculator's state.
     * <p>
     * This method performs the following steps:
     * <ul>
     * <li>Resets the current value to 0.</li>
     * <li>Clears any error messages in the state.</li>
     * <li>Disables decimal mode.</li>
     * <li>Prepares the state for a new entry.</li>
     * </ul>
     * </p>
     *
     * @param state the current state of the calculator
     */
    @Override
    public void execute(State state) {
        state.setCurrentValue(0.0);  // Resets the current value to 0
        state.clearError();          // Clears any error messages
        state.setDecimalMode(false); // Disables decimal mode
        state.setNewEntry(true);     // Prepares for a new entry
    }
}
