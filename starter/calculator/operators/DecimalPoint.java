package calculator.operators;

import calculator.Operator;
import calculator.State;

public class DecimalPoint extends Operator {

    @Override
    public void execute(State state) {
        // Si déjà en mode décimal, ne rien faire
        if (state.isDecimalMode()) {
            return;
        }

        // Active le mode décimal
        state.setDecimalMode(true);

        // Si la valeur courante est un entier, ajoute le "." à l'affichage
        if (state.getCurrentValue() == state.getCurrentValue().intValue()) {
            state.setCurrentValue(state.getCurrentValue()); // Assure qu'elle reste un double
        }
    }
}
