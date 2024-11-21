package calculator.operators;

import calculator.Operator;
import calculator.State;

public class DecimalPoint extends Operator {
    @Override
    public void execute(State state) {
        // Si un résultat est affiché, réinitialise pour une nouvelle saisie
        if (state.isResultDisplayed()) {
            state.setCurrentValue(0.0);    // Réinitialise la valeur courante
            state.setResultDisplayed(false); // Désactive le drapeau de résultat affiché
            state.setNewEntry(false);      // Active la saisie
        }

        // Récupère la valeur courante sous forme de chaîne
        String currentValueStr = state.getCurrentValueAsString();

        // Si la valeur courante ne contient pas déjà un point, ajoute-le
        if (!currentValueStr.contains(".")) {
            currentValueStr += "."; // Ajoute le point décimal
        }

        // Met à jour la valeur courante avec la nouvelle chaîne
        state.setCurrentValue(Double.parseDouble(currentValueStr + "0")); // Ajoute "0" après le point pour garder cohérence
        state.setNewEntry(false); // Désactive le mode "nouvelle entrée"
    }
}
