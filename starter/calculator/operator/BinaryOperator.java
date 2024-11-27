package calculator.operator;

import state.State;

/**
 * Represents the base class for binary operators.
 * <p>
 * Binary operators perform operations on two values: the top value of the stack (left operand)
 * and the current value of the calculator (right operand).
 * Derived classes must implement the {@code binaryOperation}
 * method to define the specific logic.
 */
public abstract class BinaryOperator extends UnaryOperator {

    /**
     * Performs the unary operation using binary operands.
     * <p>
     * Retrieves the left operand from the stack and the right operand from the current value.
     * Applies the binary operation and returns the result.
     *
     * @param value the current value of the calculator (right operand)
     * @param state the current state of the calculator
     * @return the result of the binary operation
     */
    @Override
    protected double unaryOperation(double value, State state) {
        double leftOperand = state.pop(); // Retrieve the top value from the stack
        state.setNewEntry(true);
        return binaryOperation(leftOperand, value); // Perform the binary operation
    }

    /**
     * Abstract method to define the specific binary operation.
     *
     * @param left  the left operand (value from the stack)
     * @param right the right operand (current value)
     * @return the result of the binary operation
     */
    protected abstract double binaryOperation(double left, double right);
}
