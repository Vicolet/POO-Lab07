package test;

import starter.JCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the JCalculator class.
 * <p>
 * This class validates the behavior of the graphical calculator interface,
 * including operations and state transitions.
 * </p>
 * @author Léon Surbeck
 * @author Victor Nicolet
 * @date 20.11.2024
 */
public class JCalculatorTest {

    private JCalculator calculator;
    private JTextField displayField;
    private JList<String> stackDisplay;

    /**
     * Sets up the JCalculator and its components before each test.
     * <p>
     * Ensures the components are accessible and not null.
     * </p>
     */
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
     *
     * @return the stack contents as an array of strings
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
     *
     * @param label the label of the button to click
     */
    private void clickButton(String label) {
        JButton button = TestUtils.getButtonByLabel(calculator, label);
        assertNotNull(button, "Button with label '" + label + "' not found.");
        button.doClick();
    }

    // ----------- Operator Tests --------------

    /**
     * Tests the addition operator.
     * <p>
     * Validates that clicking "1", "Ent", "2", and "+" results in "3".
     * </p>
     */
    @Test
    public void testAdd() {
        clickButton("1");
        clickButton("Ent");
        clickButton("2");
        clickButton("+");

        assertEquals("3", displayField.getText(), "Addition result should be 3.0");
    }

    /**
     * Tests the backspace operator.
     * <p>
     * Validates that clicking "1", "2", and "<=" results in "1".
     * </p>
     */
    @Test
    public void testBackspace() {
        clickButton("1");
        clickButton("2");
        clickButton("<=");

        assertEquals("1", displayField.getText(), "Backspace should remove the last digit");
    }

    /**
     * Tests the ClearAll operator.
     * <p>
     * Validates that clicking "1", "Ent", and "C" resets the display to "0".
     * </p>
     */
    @Test
    public void testClearAll() {
        clickButton("1");
        clickButton("Ent");
        clickButton("C");

        assertEquals("0", displayField.getText(), "ClearAll should reset the display to 0");
    }

    /**
     * Tests the ClearError operator.
     * <p>
     * Validates that clicking "5", "Ent", "3", and "CE" resets the display to "0".
     * </p>
     */
    @Test
    public void testClearError() {
        clickButton("5");
        clickButton("Ent");
        clickButton("3");
        clickButton("CE");

        assertEquals("0", displayField.getText(), "ClearError should reset the display to 0");
    }

    /**
     * Tests the DecimalPoint operator.
     * <p>
     * Validates that clicking "3" and "." results in "3.".
     * </p>
     */
    @Test
    public void testDecimalPoint() {
        clickButton("3");
        clickButton(".");

        assertEquals("3.", displayField.getText(), "Decimal point should display correctly");
    }

    /**
     * Tests the Divide operator.
     * <p>
     * Validates that clicking "8", "Ent", "4", and "/" results in "2".
     * </p>
     */
    @Test
    public void testDivide() {
        clickButton("8");
        clickButton("Ent");
        clickButton("4");
        clickButton("/");

        assertEquals("2", displayField.getText(), "Division result should be 2.0");
    }

    /**
     * Tests the Enter operator.
     * <p>
     * Validates that clicking "7" and "Ent" pushes the value "7" onto the stack.
     * </p>
     */
    @Test
    public void testEnter() {
        clickButton("7");
        clickButton("Ent");

        assertArrayEquals(new String[]{"7"}, getStackContents(), "Enter should push the current value onto the stack");
    }

    /**
     * Tests the Inverse operator.
     * <p>
     * Validates that clicking "4" and "1/x" results in "0.25".
     * </p>
     */
    @Test
    public void testInverse() {
        clickButton("4");
        clickButton("1/x");

        assertEquals("0.25", displayField.getText(), "Inverse result should be 0.25");
    }

    /**
     * Tests the Memory Recall and Store operators.
     * <p>
     * Validates that storing "5", clearing the display, and recalling results in "5".
     * </p>
     */
    @Test
    public void testMemoryRecallAndStore() {
        clickButton("5");
        clickButton("MS");
        clickButton("CE");
        clickButton("MR");

        assertEquals("5", displayField.getText(), "MemoryRecall should retrieve the stored value");
    }

    /**
     * Tests the Multiply operator.
     * <p>
     * Validates that clicking "3", "Ent", "5", and "*" results in "15".
     * </p>
     */
    @Test
    public void testMultiply() {
        clickButton("3");
        clickButton("Ent");
        clickButton("5");
        clickButton("*");

        assertEquals("15", displayField.getText(), "Multiplication result should be 15.0");
    }

    /**
     * Tests the Negate operator.
     * <p>
     * Validates that clicking "6" and "+/-" results in "-6".
     * </p>
     */
    @Test
    public void testNegate() {
        clickButton("6");
        clickButton("+/-");

        assertEquals("-6", displayField.getText(), "Negation result should be -6.0");
    }

    /**
     * Tests the Number operator.
     * <p>
     * Validates that clicking "7" updates the display to "7".
     * </p>
     */
    @Test
    public void testNumber() {
        clickButton("7");

        assertEquals("7", displayField.getText(), "Number button should correctly update the display");
    }

    /**
     * Tests the Sqrt operator.
     * <p>
     * Validates that clicking "16" and "Sqrt" results in "4".
     * </p>
     */
    @Test
    public void testSqrt() {
        clickButton("1");
        clickButton("6");
        clickButton("Sqrt");

        assertEquals("4", displayField.getText(), "Square root result should be 4.0");
    }

    /**
     * Tests the Square operator.
     * <p>
     * Validates that clicking "3" and "x^2" results in "9".
     * </p>
     */
    @Test
    public void testSquare() {
        clickButton("3");
        clickButton("x^2");

        assertEquals("9", displayField.getText(), "Square result should be 9.0");
    }

    /**
     * Tests the Subtract operator.
     * <p>
     * Validates that clicking "10", "Ent", "4", and "-" results in "6".
     * </p>
     */
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
