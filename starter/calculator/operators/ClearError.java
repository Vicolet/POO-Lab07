package calculator.operators;

import calculator.Operator;
import calculator.State;

public class ClearError extends Operator {
    @Override
    public void execute(State state) {
        state.setCurrentValue(0.0);  // Réinitialise la valeur courante à 0
        state.clearError();          // Supprime tout message d'erreur
        state.setDecimalMode(false); // Désactive le mode décimal
    }
}
