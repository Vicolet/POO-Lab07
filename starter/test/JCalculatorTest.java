package test;

import starter.JCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

public class JCalculatorTest {
    private JCalculator calculator;
    private JTextField displayField;
    private JList<String> stackDisplay;

    @BeforeEach
    public void setUp() {
        calculator = new JCalculator();

        // Access the components for validation
        displayField = (JTextField) TestUtils.getComponentByName(calculator, "jNumber");
        stackDisplay = (JList<String>) TestUtils.getComponentByName(calculator, "jStack");

        assertNotNull(displayField, "Display field (jNumber) should not be null.");
        assertNotNull(stackDisplay, "Stack display (jStack) should not be null.");
    }

    /**
     * Extracts the stack contents into a String array for validation.
     */
    private String[] getStackContents() {
        ListModel<String> model = stackDisplay.getModel();
        String[] stackArray = new String[model.getSize()];
        for (int i = 0; i < model.getSize(); i++) {
            stackArray[i] = model.getElementAt(i);
        }
        return stackArray;
    }

    /**
     * Simulates a button click by finding the button and invoking its action listener.
     */
    private void clickButton(String label) {
        JButton button = TestUtils.getButtonByLabel(calculator, label);
        assertNotNull(button, "Button with label '" + label + "' not found.");
        button.doClick();
    }

    // ----------- Operator Tests --------------

    @Test
    public void testAdd() {
        clickButton("1");
        clickButton("Ent");
        clickButton("2");
        clickButton("+");

        assertEquals("3", displayField.getText(), "Addition result should be 3.0");
    }

    @Test
    public void testBackspace() {
        clickButton("1");
        clickButton("2");
        clickButton("<=");

        assertEquals("1", displayField.getText(), "Backspace should remove the last digit");
    }

    @Test
    public void testClearAll() {
        clickButton("1");
        clickButton("Ent");
        clickButton("C");

        assertEquals("0", displayField.getText(), "ClearAll should reset the display to 0");
    }

    @Test
    public void testClearError() {
        clickButton("5");
        clickButton("Ent");
        clickButton("3");

        clickButton("CE");

        assertEquals("0", displayField.getText(), "ClearError should reset the display to 0");
    }

    @Test
    public void testDecimalPoint() {
        clickButton("3");
        clickButton(".");

        assertEquals("3.", displayField.getText(), "Decimal point should display correctly");
    }

    @Test
    public void testDivide() {
        clickButton("8");
        clickButton("Ent");
        clickButton("4");
        clickButton("/");

        assertEquals("2", displayField.getText(), "Division result should be 2.0");
    }

    @Test
    public void testEnter() {
        clickButton("7");
        clickButton("Ent");

        assertArrayEquals(new String[]{"7"}, getStackContents(), "Enter should push the current value onto the stack");
    }

    @Test
    public void testInverse() {
        clickButton("4");
        clickButton("1/x");

        assertEquals("0.25", displayField.getText(), "Inverse result should be 0.25");
    }

    @Test
    public void testMemoryRecallAndStore() {
        clickButton("5");
        clickButton("MS");
        clickButton("CE");
        clickButton("MR");

        assertEquals("5", displayField.getText(), "MemoryRecall should retrieve the stored value");
    }

    @Test
    public void testMultiply() {
        clickButton("3");
        clickButton("Ent");
        clickButton("5");
        clickButton("*");

        assertEquals("15", displayField.getText(), "Multiplication result should be 15.0");
    }

    @Test
    public void testNegate() {
        clickButton("6");
        clickButton("+/-");

        assertEquals("-6", displayField.getText(), "Negation result should be -6.0");
    }

    @Test
    public void testNumber() {
        clickButton("7");

        assertEquals("7", displayField.getText(), "Number button should correctly update the display");
    }

    @Test
    public void testSqrt() {
        clickButton("1");
        clickButton("6");
        clickButton("Sqrt");

        assertEquals("4", displayField.getText(), "Square root result should be 4.0");
    }

    @Test
    public void testSquare() {
        clickButton("3");
        clickButton("x^2");

        assertEquals("9", displayField.getText(), "Square result should be 9.0");
    }

    @Test
    public void testSubtract() {
        clickButton("1");
        clickButton("0");
        clickButton("Ent");
        clickButton("4");
        clickButton("-");

        assertEquals("6", displayField.getText(), "Subtraction result should be 6.0");
    }

    // ----------- Extended Tests --------------

    @Test
    public void testAddWithMultipleEntries() {
        clickButton("5");
        clickButton("Ent");
        clickButton("2");
        clickButton("Ent");
        clickButton("3");
        clickButton("+");
        clickButton("+");

        assertEquals("10", displayField.getText(), "Result of 5 + 2 + 3 should be 10.0");
    }

    @Test
    public void testDecimalPointMultipleTimes() {
        clickButton("3");
        clickButton(".");
        clickButton(".");
        clickButton("1");

        assertEquals("3.1", displayField.getText(), "Decimal point should appear only once and combine with 1");
    }

    @Test
    public void testBackspaceWithDecimal() {
        clickButton("4");
        clickButton(".");
        clickButton("2");
        clickButton("<=");

        assertEquals("4.", displayField.getText(), "Backspace should remove only the last digit");
        clickButton("<=");
        assertEquals("4", displayField.getText(), "Backspace should remove the decimal point");
        clickButton("<=");
        assertEquals("0", displayField.getText(), "Backspace should remove the last digit");
    }

    @Test
    public void testDivideByZero() {
        clickButton("8");
        clickButton("Ent");
        clickButton("0");
        clickButton("/");

        assertEquals("Error: Division by zero", displayField.getText(), "Division by zero should show an error");
    }

    @Test
    public void testEnterPushesValue() {
        clickButton("3");
        clickButton("Ent");

        assertArrayEquals(new String[]{"3"}, getStackContents(), "Stack should contain 3 after Enter");
    }

    @Test
    public void testComplexExpression() {
        clickButton("5");
        clickButton("Ent");
        clickButton("3");
        clickButton("+");
        clickButton("2");
        clickButton("*");
        clickButton("1/x");

        assertEquals("0.0625", displayField.getText(), "Result of 1 / (2 * (5 + 3)) should be 0.0625");
    }

    @Test
    public void testClearErrorResetsOnlyDisplay() {
        clickButton("4");
        clickButton("Ent");
        clickButton("7");
        clickButton("/");
        clickButton("0");
        clickButton("/");

        assertEquals("Error: Division by zero", displayField.getText(), "Division by zero should show an error");

        clickButton("CE");
        assertEquals("0", displayField.getText(), "ClearError should reset display to 0");
    }

    @Test
    public void testMemoryStoreAndRecall() {
        clickButton("8");
        clickButton("MS");
        clickButton("CE");
        clickButton("MR");

        assertEquals("8", displayField.getText(), "MemoryRecall should retrieve the stored value");
    }

    @Test
    public void testNegateOnNegativeNumber() {
        clickButton("7");
        clickButton("+/-");
        clickButton("+/-");

        assertEquals("7", displayField.getText(), "Double negate should return to original positive value");
    }

    @Test
    public void testSquareAndSquareRoot() {
        clickButton("4");
        clickButton("x^2");
        assertEquals("16", displayField.getText(), "Square of 4 should be 16");

        clickButton("Sqrt");
        assertEquals("4", displayField.getText(), "Square root of 16 should return 4");
    }

    @Test
    public void testMultipleStackOperations() {
        clickButton("2");
        clickButton("Ent");
        clickButton("3");
        clickButton("Ent");
        clickButton("4");

        clickButton("+");
        assertEquals("7", displayField.getText(), "Top of stack (3 + 4) should result in 7");

        clickButton("+");
        assertEquals("9", displayField.getText(), "Remaining stack (2 + 7) should result in 9");
    }

    @Test
    public void testDecimalPointAfterEnter() {
        clickButton("1");
        clickButton("Ent");
        clickButton("2");
        clickButton(".");
        clickButton("5");

        assertEquals("2.5", displayField.getText(), "Decimal numbers should append after an Enter");
    }

    @Test
    public void testChainedOperations() {
        clickButton("2");
        clickButton("Ent");
        clickButton("3");
        clickButton("+");
        clickButton("4");
        clickButton("*");

        assertEquals("20", displayField.getText(), "Result of (2 + 3) * 4 should be 20");
    }
}
