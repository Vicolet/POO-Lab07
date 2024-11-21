package calculator.operators;

import calculator.Operator;
import calculator.State;

public class Number extends Operator {
    private final int digit;

    public Number(int digit) {
        this.digit = digit; // Stocke le chiffre associé à ce bouton
    }

    @Override
    public void execute(State state) {
        String currentValueStr = state.getCurrentValueAsString();

        // Si la valeur courante est "0" ou vide, remplacez-la par le chiffre
        if (currentValueStr.equals("") || currentValueStr.equals("0")) {
            currentValueStr = Integer.toString(digit);
        } else if (state.isDecimalMode()) {
            // Si en mode décimal, ajoutez le chiffre après le "."
            currentValueStr += digit;
        } else {
            // Sinon, ajoutez le chiffre normalement
            currentValueStr += digit;
        }

        // Désactive le mode décimal après l'ajout d'un chiffre
        state.setDecimalMode(false);

        // Met à jour la valeur courante
        state.setCurrentValue(Double.parseDouble(currentValueStr));
    }
}
