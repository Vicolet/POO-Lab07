package calculator.operators;

import calculator.Operator;
import calculator.State;

public class Divide extends Operator {
    @Override
    public void execute(State state) {
        if (state.getStack().isEmpty()) {
            state.setError("Erreur : Pile vide");
            return;
        }

        double stackTop = state.pop();
        double current = state.getCurrentValue();

        if (current == 0) {
            state.setError("Erreur : Division par zéro");
            return;
        }

        double result = stackTop / current;

        state.setCurrentValue(result);
        state.setNewEntry(true);
        state.setResultDisplayed(true);
    }
}
