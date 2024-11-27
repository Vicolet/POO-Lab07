package calculator.operator;

/**
 * Base class for division-related operations.
 * Handles logic specific to division, including division by zero checks.
 */
public abstract class DivisionBase extends BinaryOperator {

    /**
     * Constructor for DivisionBase.
     */
    public DivisionBase() {
        super();
    }

    @Override
    protected double operation(double left, double right) {
        if (right == 0) {
            throw new ArithmeticException("Error: Division by zero");
        }
        return left / right;
    }
}
