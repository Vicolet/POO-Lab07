package calculator.operators;

import calculator.Operator;
import calculator.State;

public class Number extends Operator {
    private final int digit;

    public Number(int digit) {
        this.digit = digit;  // Stocke le chiffre associé à ce bouton
    }

    @Override
    public void execute(State state) {
        String currentValueStr = state.getCurrentValueAsString();  // Récupère la valeur courante formatée

        // Si la valeur courante est vide ou égale à "0", remplace-la par le chiffre
        if (currentValueStr.equals("") || currentValueStr.equals("0")) {
            currentValueStr = Integer.toString(digit);
        } else {
            // Sinon, ajoute le chiffre à la fin de la chaîne
            currentValueStr += digit;
        }

        // Convertit la chaîne en Double et met à jour l'état
        state.setCurrentValue(Double.parseDouble(currentValueStr));

        // Formatage de la valeur mise à jour (utilisation facultative si getCurrentValueAsString() s'en charge)
        state.setCurrentValue(Double.valueOf(state.formatDouble(state.getCurrentValue())));
    }
}
