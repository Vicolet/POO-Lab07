package calculator.implementations;

import calculator.operator.UnaryOperator;

/**
 * Represents the backspace operator. This operator removes the last digit
 * or character from the current value. If the resulting value becomes empty
 * or invalid, it resets to 0.
 */
public class Backspace extends UnaryOperator {

    /**
     * Performs the backspace operation on the current value.
     * <p>
     * This operation removes the last character from the current value. If the
     * resulting value is empty or invalid, it resets to 0.
     *
     * @param value the current value of the calculator
     * @return the updated value after the backspace operation
     */
    @Override
    protected double operation(double value) {
        String currentValueStr = String.valueOf(value);

        // If the current value is "0" or empty, reset it to 0
        if (currentValueStr.equals("0") || currentValueStr.isEmpty()) {
            return 0.0;
        }

        // Remove the last character
        currentValueStr = currentValueStr.substring(0, currentValueStr.length() - 1);

        // If the resulting string is empty, reset the value to 0
        if (currentValueStr.isEmpty()) {
            return 0.0;
        }

        // Convert back to a double
        try {
            return Double.parseDouble(currentValueStr);
        } catch (NumberFormatException e) {
            return 0.0; // Reset to 0 in case of a parsing error
        }
    }
}
