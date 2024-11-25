package calculator;

import calculator.operators.*;
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
        clickButton("0");
        clickButton("/");

        assertEquals("Error: Division by zero", displayField.getText(), "Division by zero should show an error");

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
}
