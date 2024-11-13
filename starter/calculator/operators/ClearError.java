package calculator.operators;

import calculator.Operator;
import calculator.State;

public class ClearError extends Operator {
    @Override
    public void execute(State state) {
        state.clearError();  // Efface seulement l'erreur sans affecter la pile ou la valeur courante
    }
}
