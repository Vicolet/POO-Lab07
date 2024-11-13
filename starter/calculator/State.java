package calculator;

import util.Stack;

public class State {
    private Stack<Double> stack = new Stack<>();
    private Double currentValue = 0.0;
    private Double memory = null;
    private String errorMessage = null;

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
}