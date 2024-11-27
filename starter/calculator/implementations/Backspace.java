package calculator.implementations;

import calculator.operator.DefaultOperator;

/**
 * Represents the backspace operator. This operator removes the last digit
 * or character from the current value. If the resulting value becomes empty
 * or invalid, it resets to 0.
 */
public class Backspace extends DefaultOperator {

    /**
     * Performs the backspace operation on the current value.
     * <p>
     * Removes the last character from the current value. If the resulting value
     * is empty or invalid, it resets to 0.
     *
     * @param value the current value of the calculator
     * @return the updated value after the backspace operation
     */
    @Override
    protected double operation(double value) {
        // Convert the current value to a string
        String currentValueStr = String.valueOf(value);

        // Handle edge case where the value is "0" or already empty
        if (currentValueStr.equals("0") || currentValueStr.isEmpty()) {
            return 0.0; // Reset to 0
        }

        // If the value contains a decimal point and ends with ".0", simplify it
        if (currentValueStr.endsWith(".0")) {
            currentValueStr = currentValueStr.substring(0, currentValueStr.length() - 2);
        }

        // Remove the last character
        currentValueStr = currentValueStr.substring(0, currentValueStr.length() - 1);

        // If the resulting string is empty, reset to 0
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
