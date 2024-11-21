package calculator;

import util.Stack;

public class State {
    private Stack<Double> stack = new Stack<>();
    private Double currentValue = 0.0;
    private Double memory = null;
    private String errorMessage = null;
    private boolean isDecimalMode = false;


    /**
     * Pushes the current value to the stack and resets the current value to 0.
     */
    public void pushCurrentValue() {
        stack.push(currentValue);
        currentValue = 0.0;
    }

    /**
     * Pops the top value from the stack and sets it as the current value.
     *
     * @return the popped value
     */
    public Double pop() {
        return stack.isEmpty() ? 0.0 : stack.pop();
    }

    /**
     * Stores the current value in memory.
     */
    public void storeInMemory() {
        memory = currentValue;
    }

    /**
     * Recalls the value stored in memory.
     *
     * @return the value stored in memory
     */
    public Double recallFromMemory() {
        return memory != null ? memory : 0.0;
    }

    /**
     * Clears the value stored in memory.
     */
    public void setError(String message) {
        errorMessage = message;
    }

    /**
     * Returns the error message.
     *
     * @return the error message
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

    /**
     * Returns the current value.
     *
     * @return the current value
     */
    public Double getCurrentValue() {
        return currentValue;
    }

    /**
     * Sets the current value.
     *
     * @param value the value to set
     */
    public void setCurrentValue(Double value) {
        currentValue = value;
    }

    public String getCurrentValueAsString() {
        if (isDecimalMode && currentValue == currentValue.intValue()) {
            return currentValue.intValue() + "."; // Ajoute un "." pour indiquer le mode décimal
        }

        if (currentValue == currentValue.intValue()) {
            return String.valueOf(currentValue.intValue()); // Affiche comme un entier si pas en mode décimal
        }

        return currentValue.toString(); // Sinon, affiche comme un double
    }

    /**
     * Clears all values in the stack and resets the current value to 0.
     */
    public void clearAll() {
        stack = new Stack<>();
        currentValue = 0.0;
        clearError();
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
     * Returns the stack as an array of strings.
     *
     * @return the stack as an array of strings
     */
    public String[] getStackArray() {
        Object[] stackObjects = stack.toArray(); // Convertit la pile en tableau d'objets
        String[] stackStrings = new String[stackObjects.length];

        for (int i = 0; i < stackObjects.length; i++) {
            stackStrings[i] = formatDouble((Double) stackObjects[i]);
        }
        return stackStrings;
    }

    /**
     * Formats a double value to a string.
     *
     * @param value the value to format
     * @return the formatted value
     */
    public String formatDouble(Double value) {
        if (value == null) {
            return ""; // Retourne une chaîne vide si la valeur est null
        }
        if (value == value.intValue()) {
            return String.valueOf(value.intValue()); // Si c'est un entier, affiche sans ".0"
        }
        return value.toString(); // Sinon, retourne le Double sous sa forme classique
    }

    public boolean isDecimalMode() {
        return isDecimalMode;
    }

    public void setDecimalMode(boolean decimalMode) {
        isDecimalMode = decimalMode;
    }

}