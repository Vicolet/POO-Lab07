package calculator.operators;

import calculator.Operator;
import calculator.State;

public class Sqrt extends Operator {
    @Override
    public void execute(State state) {
        double current = state.getCurrentValue();

        if (current < 0) {
            state.setError("Erreur : Racine carrée d'un nombre négatif");
            return;
        }

        double result = Math.sqrt(current);

        state.setCurrentValue(result);
        state.setNewEntry(true);
        state.setResultDisplayed(true);
    }
}
