package calculator.operators;

import calculator.Operator;
import calculator.State;

public class Add extends Operator {
    @Override
    public void execute(State state) {
        if (state.getStack().isEmpty()) {
            state.setError("Erreur : Pile vide");
            return;
        }

        double stackTop = state.pop(); // Récupère le sommet de la pile
        double current = state.getCurrentValue(); // Récupère la valeur courante

        // Effectue l'opération
        double result = stackTop + current;

        // Met à jour l'état avec le résultat
        state.setCurrentValue(result);
        state.setNewEntry(true); // Active le mode "nouvelle entrée"
        state.setResultDisplayed(true); // Indique que le résultat est affiché
    }
}
