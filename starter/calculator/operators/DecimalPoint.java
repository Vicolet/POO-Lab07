package calculator.operators;

import calculator.Operator;
import calculator.State;

public class DecimalPoint extends Operator {
    @Override
    public void execute(State state) {
        // Si un résultat est affiché, réinitialiser pour une nouvelle entrée
        if (state.isResultDisplayed()) {
            state.setCurrentValue(0.0); // Réinitialise à 0
            state.setResultDisplayed(false);
            state.setNewEntry(false);  // Prépare la saisie
        }

        // Récupère la valeur actuelle sous forme de chaîne
        String currentValueStr = state.getCurrentValueAsString();

        // Ajoute un point décimal uniquement s'il n'est pas déjà présent
        if (!currentValueStr.contains(".")) {
            currentValueStr += "."; // Ajoute un point
            state.setCurrentValueString(currentValueStr); // Mise à jour en tant que chaîne temporaire
        }

        // Désactive le mode "nouvelle entrée"
        state.setNewEntry(false);
    }
}
