package calculator;

import calculator.operators.*;
import calculator.operators.Number;

import java.util.Scanner;

/**
 * The Calculator class represents a simple calculator with basic arithmetic operations.
 * It uses a stack-based approach to process user input and perform calculations.
 * The calculator supports addition, subtraction, multiplication, division, square root,
 * square, inverse, negate, memory recall, memory store, backspace, clear error,
 * clear, and enter operations. The calculator runs in a command-line interface.
 */
public class Calculator {
    private final State state;

    public Calculator() {
        this.state = new State(); // Initialize the calculator state
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            processInput(input);

            displayState();
        }

        System.out.println("Exiting calculator.");
    }

    /**
     * Processes the user input and executes the corresponding operation.
     *
     * @param input the user input
     */
    private void processInput(String input) {
        Operator operator = OperatorList.createOperator(input, state);

        if (operator != null) {
            operator.execute(state);

            if (state.getError() == null) { // No error
                // Display the current state or result
                System.out.println("Result: " + state.getCurrentValueAsString());
            } else {
                // Display the error message
                System.out.println("Error: " + state.getError());
                state.clearError(); // Clear the error after displaying it
            }
        }
    }

    /**
     * Displays the current state of the stack and the current value.
     */
    private void displayState() {
        System.out.println("Stack: " + String.join(" ", state.getStackArray()));
        System.out.println("Current: " + state.getCurrentValueAsString());
    }

    /**
     * Inner class to manage operators and map user input to corresponding operations.
     */
    public static class OperatorList {
        public static Operator createOperator(String input, State state) {
            switch (input.toLowerCase()) {
                case "+":
                    return new Add();
                case "-":
                    return new Subtract();
                case "*":
                    return new Multiply();
                case "/":
                    return new Divide();
                case "sqrt":
                    return new Sqrt();
                case "x^2":
                    return new Square();
                case "1/x":
                    return new Inverse();
                case "+/-":
                    return new Negate();
                case "mr":
                    return new MemoryRecall();
                case "ms":
                    return new MemoryStore();
                case "<=":
                    return new Backspace();
                case "ce":
                    return new ClearError();
                case "c":
                    return new ClearAll();
                case "ent": // Handling the "Enter" operation
                    return new Enter();
                default:
                    try {
                        // If the input is numeric, create a Number operator
                        return new Number(Integer.parseInt(input));
                    } catch (NumberFormatException e) {
                        System.out.println("Unknown operator or invalid input: " + input);
                        return null;
                    }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the Calculator.");
        Calculator calculator = new Calculator();
        calculator.run();
    }
}
