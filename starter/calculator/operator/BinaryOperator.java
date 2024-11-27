package calculator.operator;

import state.State;

/**
 * Represents the base class for binary operators.
 * <p>
 * Binary operators perform operations on two values: the top value of the stack (left operand)
 * and the current value of the calculator (right operand).
 * Derived classes must implement the {@code binaryOperation}
 * method to define the specific logic.
 * </p>
 *
 * @author Léon Surbeck
 * @author Victor Nicolet
 * @date 20.11.2024
 */
public abstract class BinaryOperator extends UnaryOperator {

    /**
     * Performs the unary operation using binary operands.
     * <p>
     * Retrieves the left operand from the stack and the right operand from the current value.
     * Applies the binary operation and returns the result. Updates the state to indicate
     * that a result is currently displayed.
     * </p>
     *
     * @param value the current value of the calculator (right operand)
     * @param state the current state of the calculator
     * @return the result of the binary operation
     */
    @Override
    protected double unaryOperation(double value, State state) {
        if (state.getStack().isEmpty()) {
            return Double.NaN;
        }
        double leftOperand = state.pop(); // Retrieve the top value from the stack
        double result = binaryOperation(leftOperand, value); // Perform the binary operation
        state.setResultDisplayed(true); // Mark the result as displayed
        return result;
    }

    /**
     * Abstract method to define the specific binary operation.
     * <p>
     * Derived classes must implement this method to provide the logic
     * for combining the left and right operands.
     * </p>
     *
     * @param left  the left operand (value from the stack)
     * @param right the right operand (current value)
     * @return the result of the binary operation
     */
    protected abstract double binaryOperation(double left, double right);
}
