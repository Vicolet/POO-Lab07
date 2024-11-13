package calculator.operators;

import calculator.Operator;
import calculator.State;

public class ClearAll extends Operator {
    @Override
    public void execute(State state) {
        state.clearAll();  // Efface la pile, la valeur courante et les erreurs
    }
}
