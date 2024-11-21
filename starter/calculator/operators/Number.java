package calculator.operators;

import calculator.Operator;
import calculator.State;

public class Number extends Operator {
    private final int digit;

    public Number(int digit) {
        this.digit = digit;
    }

    @Override
    public void execute(State state) {
        // Si le résultat d'une opération est affiché, pousse-le dans la pile
        if (state.isResultDisplayed()) {
            state.pushCurrentValue(); // Pousse le résultat dans la pile
            state.setResultDisplayed(false); // Désactive l'indicateur de résultat affiché
        }

        // Si en mode nouvelle entrée (après Backspace ou opération), remplace "0"
        if (state.isNewEntry()) {
            state.setCurrentValue((double) digit); // Remplace par la nouvelle valeur
            state.setNewEntry(false); // Désactive le mode "nouvelle entrée"
        } else {
            // Récupère la valeur actuelle sous forme de chaîne
            String currentValueStr = state.getCurrentValueAsString();

            // Ajoute le chiffre à la fin de la chaîne
            if (currentValueStr.equals("0")) {
                currentValueStr = Integer.toString(digit); // Remplace "0" par le chiffre
            } else {
                currentValueStr += digit; // Ajoute le chiffre
            }

            // Met à jour la valeur actuelle
            state.setCurrentValue(Double.parseDouble(currentValueStr));
        }
    }
}
