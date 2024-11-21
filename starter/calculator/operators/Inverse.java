package calculator.operators;

import calculator.Operator;
import calculator.State;

public class Inverse extends Operator {
    @Override
    public void execute(State state) {
        double current = state.getCurrentValue();

        // Vérifie la division par zéro
        if (current == 0) {
            state.setError("Erreur : Division par zéro");
            return;
        }

        // Effectue l'inversion
        double result = 1 / current;

        // Met à jour l'état
        state.setCurrentValue(result);
        state.setNewEntry(true);       // Active le mode "nouvelle entrée"
        state.setResultDisplayed(true); // Indique que le résultat est affiché
    }
}
