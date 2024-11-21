package calculator.operators;

import calculator.Operator;
import calculator.State;

public class ClearAll extends Operator {
    @Override
    public void execute(State state) {
        state.clearAll();           // Vide la pile, réinitialise la valeur courante et les erreurs
        state.setCurrentValue(0.0); // Réinitialise la valeur courante à 0
        state.setNewEntry(true);    // Active le mode "nouvelle entrée"
    }
}
