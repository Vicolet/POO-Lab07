package calculator.operators;

import calculator.Operator;
import calculator.State;

public class Backspace extends Operator {

    @Override
    public void execute(State state) {
        // Si en mode nouvelle entrée, réinitialise à 0 sans modifier la pile
        if (state.isNewEntry()) {
            state.setCurrentValue(0.0);
            state.setNewEntry(true); // Reste en mode nouvelle entrée
            return;
        }

        // Récupère la valeur actuelle sous forme de chaîne
        String currentValueStr = state.getCurrentValueAsString();

        // Si la valeur est "0" ou vide, réinitialise à 0
        if (currentValueStr.equals("0") || currentValueStr.isEmpty()) {
            state.setCurrentValue(0.0);
            state.setNewEntry(true); // Reste en mode nouvelle entrée
            return;
        }

        // Supprime le dernier caractère
        currentValueStr = currentValueStr.substring(0, currentValueStr.length() - 1);

        // Si la chaîne devient vide après suppression, réinitialise à 0
        if (currentValueStr.isEmpty()) {
            state.setCurrentValue(0.0);
            state.setNewEntry(true); // Indique que la nouvelle valeur doit remplacer
        } else {
            // Met à jour la valeur actuelle
            state.setCurrentValue(Double.parseDouble(currentValueStr));
        }
    }
}
