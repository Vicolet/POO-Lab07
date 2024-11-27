package state;

import util.Stack;

/**
 * Represents the internal state of the calculator, including the stack,
 * current value, memory, and error messages. Provides utility methods
 * to manipulate and retrieve these values.
 */
public class State {
    private Stack<Double> stack = new Stack<>();
    private Double currentValue = 0.0;
    private Double memory = null;
    private String errorMessage = null;
    private boolean isDecimalMode = false;
    private boolean isNewEntry = true;
    private boolean isResultDisplayed = false;
    private String currentValueString = "0";

    // --- Current Value Management ---

    /**
     * Returns the current value as a double.
     *
     * @return the current value
     */
    public Double getCurrentValue() {
        return currentValue;
    }

    /**
     * Sets the current value and resets the temporary string representation.
     *
     * @param value the new current value
     */
    public void setCurrentValue(Double value) {
        this.currentValue = value;
        this.currentValueString = null;
    }

    /**
     * Returns the current value as a formatted string.
     *
     * @return the current value as a string
     */
    public String getCurrentValueAsString() {
        if (currentValueString != null) {
            return currentValueString;
        }

        if (currentValue == null || currentValue == 0.0) {
            return "0";
        }

        String valueStr = currentValue.toString();
        if (valueStr.endsWith(".0")) {
            return valueStr.substring(0, valueStr.length() - 2);
        }

        return valueStr;
    }

    /**
     * Sets the current value using a string representation and updates the double value.
     *
     * @param value the string representation of the current value
     */
    public void setCurrentValueString(String value) {
        this.currentValueString = value;
        try {
            this.currentValue = Double.parseDouble(value);
        } catch (NumberFormatException e) {
            this.currentValue = 0.0;
        }
    }

    // --- Stack Management ---

    /**
     * Pushes the current value onto the stack and resets the current value to 0.
     */
    public void pushCurrentValue() {
        if (currentValue != null) {
            stack.push(currentValue);
            currentValue = 0.0;
        }
        setNewEntry(true);
    }

    /**
     * Pops the top value from the stack and sets it as the current value.
     *
     * @return the popped value or 0 if the stack is empty
     */
    public Double pop() {
        return stack.isEmpty() ? 0.0 : stack.pop();
    }

    /**
     * Returns the stack.
     *
     * @return the stack
     */
    public Stack<Double> getStack() {
        return stack;
    }

    /**
     * Returns the stack as an array of formatted strings.
     *
     * @return the stack as an array of strings
     */
    public String[] getStackArray() {
        Object[] stackObjects = stack.toArray();
        String[] stackStrings = new String[stackObjects.length];

        for (int i = 0; i < stackObjects.length; i++) {
            stackStrings[i] = formatDouble((Double) stackObjects[i]);
        }

        return stackStrings;
    }

    /**
     * Clears all values in the stack and resets the current value and state.
     */
    public void clearAll() {
        stack = new Stack<>();
        currentValue = 0.0;
        memory = null;
        clearError();
        setNewEntry(true);
    }

    // --- Memory Management ---

    /**
     * Stores the current value in memory.
     */
    public void storeInMemory() {
        memory = currentValue;
    }

    /**
     * Recalls the value stored in memory.
     *
     * @return the value in memory or 0 if none is set
     */
    public Double recallFromMemory() {
        return memory != null ? memory : 0.0;
    }

    // --- Error Management ---

    /**
     * Sets an error message.
     *
     * @param message the error message
     */
    public void setError(String message) {
        errorMessage = message;
    }

    /**
     * Returns the error message.
     *
     * @return the error message or null if none is set
     */
    public String getError() {
        return errorMessage;
    }

    /**
     * Clears the error message.
     */
    public void clearError() {
        errorMessage = null;
    }

    // --- Formatting Utilities ---

    /**
     * Formats a double value to a string, removing ".0" for integers.
     *
     * @param value the value to format
     * @return the formatted string
     */
    public String formatDouble(Double value) {
        if (value == null) {
            return "";
        }
        if (value == value.intValue()) {
            return String.valueOf(value.intValue());
        }
        return value.toString();
    }

    // --- Flags and Modes ---

    /**
     * Returns whether the calculator is in decimal mode.
     *
     * @return true if in decimal mode, false otherwise
     */
    public boolean isDecimalMode() {
        return isDecimalMode;
    }

    /**
     * Sets the decimal mode.
     *
     * @param decimalMode true to enable decimal mode, false to disable
     */
    public void setDecimalMode(boolean decimalMode) {
        isDecimalMode = decimalMode;
    }

    /**
     * Returns whether the calculator is in new entry mode.
     *
     * @return true if in new entry mode, false otherwise
     */
    public boolean isNewEntry() {
        return isNewEntry;
    }

    /**
     * Sets the new entry mode.
     *
     * @param newEntry true to enable new entry mode, false to disable
     */
    public void setNewEntry(boolean newEntry) {
        this.isNewEntry = newEntry;
    }

    /**
     * Returns whether the result of an operation is currently displayed.
     *
     * @return true if a result is displayed, false otherwise
     */
    public boolean isResultDisplayed() {
        return isResultDisplayed;
    }

    /**
     * Sets the result displayed flag.
     *
     * @param resultDisplayed true to indicate a result is displayed, false otherwise
     */
    public void setResultDisplayed(boolean resultDisplayed) {
        this.isResultDisplayed = resultDisplayed;
    }
}
