package calculator.operators;

import calculator.Operator;
import calculator.State;

public class Multiply extends Operator {
    @Override
    public void execute(State state) {
        if (state.getStack().isEmpty()) {
            state.setError("Erreur : Pile vide");
            return;
        }

        double stackTop = state.pop();
        double current = state.getCurrentValue();

        double result = stackTop * current;

        state.setCurrentValue(result);
        state.setNewEntry(true);
        state.setResultDisplayed(true);
    }
}
