package test;

import starter.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the {@link Calculator} class.
 * <p>
 * This class validates the behavior of the text-based calculator interface,
 * including arithmetic operations, memory management, and error handling.
 * </p>
 * @author Léon Surbeck
 * @author Victor Nicolet
 * @date 20.11.2024
 */
public class CalculatorTest {

    private Calculator calculator;
    private ByteArrayOutputStream outputStream;

    /**
     * Sets up the test environment before each test.
     * <p>
     * Initializes the calculator and configures the output stream for capturing
     * console output during test execution.
     * </p>
     */
    @BeforeEach
    public void setUp() {
        calculator = new Calculator();

        // Capture output stream for validation
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream, true, StandardCharsets.UTF_8));
    }

    /**
     * Simulates user input by redirecting it to the input stream.
     *
     * @param input the simulated user input
     */
    private void simulateInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * Retrieves the captured console output.
     *
     * @return the captured console output as a trimmed string
     */
    private String getConsoleOutput() {
        return outputStream.toString(StandardCharsets.UTF_8).trim();
    }

    /**
     * Tests the addition operation.
     * <p>
     * Simulates input for adding 5 and 3 and verifies the result is displayed correctly.
     * </p>
     */
    @Test
    public void testAddition() {
        simulateInput("5\nEnt\n3\n+\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Result: 8"), "The output should display the result of 5 + 3 as 8");
    }

    /**
     * Tests the subtraction operation.
     * <p>
     * Simulates input for subtracting 4 from 10 and verifies the result is displayed correctly.
     * </p>
     */
    @Test
    public void testSubtraction() {
        simulateInput("10\nEnt\n4\n-\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Result: 6"), "The output should display the result of 10 - 4 as 6");
    }

    /**
     * Tests the multiplication operation.
     * <p>
     * Simulates input for multiplying 3 and 5 and verifies the result is displayed correctly.
     * </p>
     */
    @Test
    public void testMultiplication() {
        simulateInput("3\nEnt\n5\n*\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Result: 15"), "The output should display the result of 3 * 5 as 15");
    }

    /**
     * Tests the division operation.
     * <p>
     * Simulates input for dividing 8 by 4 and verifies the result is displayed correctly.
     * </p>
     */
    @Test
    public void testDivision() {
        simulateInput("8\nEnt\n4\n/\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Result: 2"), "The output should display the result of 8 / 4 as 2");
    }

    /**
     * Tests the square root operation.
     * <p>
     * Simulates input for finding the square root of 16 and verifies the result is displayed correctly.
     * </p>
     */
    @Test
    public void testSquareRoot() {
        simulateInput("16\nsqrt\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Result: 4"), "The output should display the result of sqrt(16) as 4");
    }

    /**
     * Tests the square operation.
     * <p>
     * Simulates input for squaring 3 and verifies the result is displayed correctly.
     * </p>
     */
    @Test
    public void testSquare() {
        simulateInput("3\nx^2\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Result: 9"), "The output should display the result of 3^2 as 9");
    }

    /**
     * Tests the negate operation.
     * <p>
     * Simulates input for negating 6 and verifies the result is displayed correctly.
     * </p>
     */
    @Test
    public void testNegate() {
        simulateInput("6\n+/-\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Result: -6"), "The output should display the negated value as -6");
    }

    /**
     * Tests the Enter operation to push a value to the stack.
     * <p>
     * Simulates input for entering 5 and verifies the stack contains the value.
     * </p>
     */
    @Test
    public void testEnterPushesValueToStack() {
        simulateInput("5\nEnt\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Stack: 5"), "The stack should contain 5 after the Enter operation");
    }

    /**
     * Tests storing and recalling values in memory.
     * <p>
     * Simulates input for storing 7 in memory, clearing the display, and recalling it.
     * </p>
     */
    @Test
    public void testMemoryStoreAndRecall() {
        simulateInput("7\nMS\nCE\nMR\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Result: 7"), "The output should display the recalled memory value as 7");
    }

    /**
     * Tests the ClearAll operation.
     * <p>
     * Simulates input for clearing the calculator and verifies the stack and display are reset.
     * </p>
     */
    @Test
    public void testClearAll() {
        simulateInput("10\nEnt\nC\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Stack: "), "The stack should be cleared after ClearAll (C)");
        assertTrue(output.contains("Current: 0"), "The current value should reset to 0 after ClearAll (C)");
    }

    /**
     * Tests division by zero handling.
     * <p>
     * Simulates input for dividing 8 by 0 and verifies an error is displayed.
     * </p>
     */
    @Test
    public void testDivisionByZero() {
        simulateInput("8\nEnt\n0\n/\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Error: Division by zero"), "The output should display an error for division by zero");
    }

    /**
     * Tests handling of invalid input.
     * <p>
     * Simulates input for an invalid command and verifies the error is handled gracefully.
     * </p>
     */
    @Test
    public void testInvalidInput() {
        simulateInput("invalid\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Unknown operator or invalid input"), "The output should handle invalid input gracefully");
    }

    /**
     * Tests the Backspace operation.
     * <p>
     * Simulates input for removing the last digit and verifies the result.
     * </p>
     */
    @Test
    public void testBackspace() {
        simulateInput("12\n<=\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Current: 1"), "Backspace should remove the last digit, leaving 1");
    }
}
