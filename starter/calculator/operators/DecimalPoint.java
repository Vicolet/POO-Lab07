package calculator.operators;

import calculator.Operator;
import calculator.State;

public class DecimalPoint extends Operator {

    @Override
    public void execute(State state) {
        String currentValueStr = state.getCurrentValueAsString();  // Récupère la valeur courante sous forme de chaîne

        // Ajoute un point décimal uniquement s'il n'est pas déjà présent
        if (!currentValueStr.contains(".")) {
            currentValueStr += ".";  // Ajoute le point décimal
        }

        // Met à jour la valeur courante après l'ajout du point décimal
        state.setCurrentValue(Double.parseDouble(currentValueStr));

        // Met à jour avec le formatage correct
        state.setCurrentValue(Double.valueOf(state.formatDouble(state.getCurrentValue())));
    }
}
