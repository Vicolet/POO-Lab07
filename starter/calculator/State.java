package calculator;

import util.Stack;

public class State {
    private Stack<Double> stack = new Stack<>();
    private Double currentValue = 0.0;
    private Double memory = null;
    private String errorMessage = null;
    private boolean isDecimalMode = false;
    private boolean isNewEntry = true;
    private boolean isResultDisplayed = false; // Indique si le résultat d'une opération est affiché
    private String currentValueString = "0"; // Valeur courante sous forme de chaîne


    /**
     * Pushes the current value to the stack and resets the current value to 0.
     */
    public void pushCurrentValue() {
        if (currentValue != null) {
            stack.push(currentValue); // Pousse la valeur courante dans la pile
            currentValue = 0.0; // Réinitialise currentValue à 0 après le push

        }
        setNewEntry(true); // Active le mode "nouvelle entrée" après le push
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
        errorMessage = null; // Supprime les erreurs existantes
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
        this.currentValue = value;
        this.currentValueString = null; // Réinitialise la chaîne temporaire
    }


    public String getCurrentValueAsString() {
        // Si une chaîne temporaire est définie, retournez-la
        if (currentValueString != null) {
            return currentValueString;
        }

        // Sinon, utilisez le format classique
        if (currentValue == null || currentValue == 0.0) {
            return "0"; // Affiche "0" si aucune valeur n'est définie
        }

        // Convertit la valeur courante en chaîne
        String valueStr = currentValue.toString();

        // Si c'est un entier, affiche sans ".0"
        if (valueStr.endsWith(".0")) {
            return valueStr.substring(0, valueStr.length() - 2);
        }

        return valueStr;
    }

    public void setCurrentValueString(String value) {
        this.currentValueString = value;
        try {
            this.currentValue = Double.parseDouble(value); // Met à jour la valeur numérique
        } catch (NumberFormatException e) {
            this.currentValue = 0.0; // Valeur par défaut en cas d'erreur
        }
    }


    /**
     * Clears all values in the stack and resets the current value to 0.
     */
    public void clearAll() {
        stack = new Stack<>();    // Vide la pile
        currentValue = 0.0;       // Réinitialise la valeur courante
        memory = null;            // Réinitialise la mémoire
        clearError();             // Supprime tout message d'erreur
        isNewEntry = true;        // Active le mode "nouvelle entrée"
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

    // Getter pour isNewEntry
    public boolean isNewEntry() {
        return isNewEntry;
    }

    // Setter pour isNewEntry
    public void setNewEntry(boolean newEntry) {
        this.isNewEntry = newEntry;
    }

    // Getter pour isResultDisplayed
    public boolean isResultDisplayed() {
        return isResultDisplayed;
    }

    // Setter pour isResultDisplayed
    public void setResultDisplayed(boolean resultDisplayed) {
        this.isResultDisplayed = resultDisplayed;
    }
}