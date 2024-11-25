package calculator;

import calculator.operators.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * A console-based calculator that utilizes the State and Operator classes
 * for performing Reverse Polish Notation (RPN) calculations.
 */
public class Calculator {
    private final State state = new State();
    private final Map<String, Operator> operators = new HashMap<>();

    /**
     * Initializes the calculator and registers all supported operators.
     */
    public Calculator() {
        // Registering basic operators
        operators.put("+", new Add());
        operators.put("-", new Subtract());
        operators.put("*", new Multiply());
        operators.put("/", new Divide());
        operators.put("sqrt", new Sqrt());
        operators.put("square", new Square());
        operators.put("negate", new Negate());
        operators.put("1/x", new Inverse());

        // Memory operators
        operators.put("ms", new MemoryStore());
        operators.put("mr", new MemoryRecall());

        // Clear operators
        operators.put("ce", new ClearError());
        operators.put("c", new ClearAll());
    }

    /**
     * Starts the console-based calculator.
     */
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Console Calculator - Type 'exit' to quit.");

        while (true) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();

            // Exit the calculator
            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye!");
                break;
            }

            try {
                // Process numerical input
                if (isNumeric(input)) {
                    double number = Double.parseDouble(input);
                    state.setCurrentValue(number);
                    new Enter().execute(state); // Push the number onto the stack
                }
                // Process operator input
                else if (operators.containsKey(input)) {
                    operators.get(input).execute(state);
                }
                // Invalid input
                else {
                    System.out.println("Error: Unknown command '" + input + "'");
                    continue;
                }

                // Display the stack on a single line
                displayStackInline();
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }

    /**
     * Checks if a string can be interpreted as a number.
     *
     * @param input the input string
     * @return true if the string is numeric, false otherwise
     */
    private boolean isNumeric(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Displays the current stack in a single line in the console.
     */
    private void displayStackInline() {
        String[] stackArray = state.getStackArray();
        if (stackArray.length == 0) {
            System.out.println("<empty stack>");
        } else {
            for (int i = stackArray.length - 1; i >= 0; i--) {
                System.out.print(stackArray[i] + " ");
            }
            System.out.println(); // Newline after the stack
        }
    }

    /**
     * Entry point for the console-based calculator.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        new Calculator().run();
    }
}
