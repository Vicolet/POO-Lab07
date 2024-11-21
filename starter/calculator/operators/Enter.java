package calculator.operators;

import calculator.Operator;
import calculator.State;

public class Enter extends Operator {
    @Override
    public void execute(State state) {
        state.pushCurrentValue();  // Pousse la valeur courante dans la pile
        state.setCurrentValue(0.0); // Réinitialise la valeur courante à 0
        state.setNewEntry(true);    // Active le mode "nouvelle entrée"
    }
}
