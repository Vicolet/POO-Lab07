package test;

import starter.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    public void setUp() {
        calculator = new Calculator();

        // Capture output stream for validation
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream, true, StandardCharsets.UTF_8));
    }

    /**
     * Simulates user input by providing it as an input stream.
     *
     * @param input the simulated user input
     */
    private void simulateInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));
    }

    /**
     * Retrieves the captured output from the console.
     *
     * @return the captured console output
     */
    private String getConsoleOutput() {
        return outputStream.toString(StandardCharsets.UTF_8).trim();
    }

    @Test
    public void testAddition() {
        simulateInput("5\nEnt\n3\n+\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Result: 8"), "The output should display the result of 5 + 3 as 8");
    }

    @Test
    public void testSubtraction() {
        simulateInput("10\nEnt\n4\n-\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Result: 6"), "The output should display the result of 10 - 4 as 6");
    }

    @Test
    public void testMultiplication() {
        simulateInput("3\nEnt\n5\n*\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Result: 15"), "The output should display the result of 3 * 5 as 15");
    }

    @Test
    public void testDivision() {
        simulateInput("8\nEnt\n4\n/\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Result: 2"), "The output should display the result of 8 / 4 as 2");
    }

    @Test
    public void testSquareRoot() {
        simulateInput("16\nsqrt\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Result: 4"), "The output should display the result of sqrt(16) as 4");
    }

    @Test
    public void testSquare() {
        simulateInput("3\nx^2\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Result: 9"), "The output should display the result of 3^2 as 9");
    }

    @Test
    public void testNegate() {
        simulateInput("6\n+/-\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Result: -6"), "The output should display the negated value as -6");
    }

    @Test
    public void testEnterPushesValueToStack() {
        simulateInput("5\nEnt\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Stack: 5"), "The stack should contain 5 after the Enter operation");
    }

    @Test
    public void testMemoryStoreAndRecall() {
        simulateInput("7\nMS\nCE\nMR\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Result: 7"), "The output should display the recalled memory value as 7");
    }

    @Test
    public void testClearAll() {
        simulateInput("10\nEnt\nC\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Stack: "), "The stack should be cleared after ClearAll (C)");
        assertTrue(output.contains("Current: 0"), "The current value should reset to 0 after ClearAll (C)");
    }

    @Test
    public void testDivisionByZero() {
        simulateInput("8\nEnt\n0\n/\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Error: Division by zero"), "The output should display an error for division by zero");
    }

    @Test
    public void testInvalidInput() {
        simulateInput("invalid\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Unknown operator or invalid input"), "The output should handle invalid input gracefully");
    }

    @Test
    public void testBackspace() {
        simulateInput("12\n<=\nexit\n");
        calculator.run();

        String output = getConsoleOutput();
        assertTrue(output.contains("Current: 1"), "Backspace should remove the last digit, leaving 1");
    }
}
