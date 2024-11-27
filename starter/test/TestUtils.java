package test;

import javax.swing.*;
import java.awt.*;

/**
 * Utility class for testing Swing components.
 * <p>
 * This class provides helper methods to find components by name or label in a container.
 * </p>
 *  *
 *  * @author Léon Surbeck
 *  * @author Victor Nicolet
 *  * @date 20.11.2024
 */
public class TestUtils {

    /**
     * Finds a component by name in a given container.
     *
     * @param container the container to search
     * @param name      the name of the component
     * @return the component, or null if not found
     */
    public static Component getComponentByName(Container container, String name) {
        for (Component component : container.getComponents()) {
            if (name.equals(component.getName())) {
                return component;
            }
            if (component instanceof Container) {
                Component found = getComponentByName((Container) component, name);
                if (found != null) {
                    return found;
                }
            }
        }
        return null;
    }

    /**
     * Finds a button by its label in a given container.
     *
     * @param container the container to search
     * @param label     the label of the button
     * @return the button, or null if not found
     */
    public static JButton getButtonByLabel(Container container, String label) {
        for (Component component : container.getComponents()) {
            if (component instanceof JButton && label.equals(((JButton) component).getText())) {
                return (JButton) component;
            }
            if (component instanceof Container) {
                JButton button = getButtonByLabel((Container) component, label);
                if (button != null) {
                    return button;
                }
            }
        }
        return null;
    }
}
