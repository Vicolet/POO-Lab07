package starter;

import calculator.operator.Operator;
import calculator.implementations.*;
import calculator.implementations.Number;
import state.State;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

// TODO: probleme de reconnaissance des nouvelle classe qui hérite de Operator dans la fonction de Jcalculator
// TODO: pourquoi je dois à chaque fois déclarer la methode operation avec un seul parametre alors que dans la classe DivisionBase il y a deux parametres
// TODO: base commune pour square et multiply

public class JCalculator extends JFrame {
    // Champ pour la gestion de l'état interne
    private final State state;  // Gère la pile, la valeur courante, et les erreurs

    // Zone de texte contenant la valeur introduite ou résultat courant
    private final JTextField jNumber = new JTextField("0");

    // Composant liste représentant le contenu de la pile
    private final JList<String> jStack = new JList<>(new String[]{"< empty stack >"});

    // Contraintes pour le placement des composants graphiques
    private final GridBagConstraints constraints = new GridBagConstraints();

    // Constructeur
    public JCalculator() {
        super("starter.JCalculator");
        state = new State();  // Initialisation de l'état interne de la calculatrice
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridBagLayout());

        // Configuration des contraintes de base
        constraints.insets = new Insets(3, 3, 3, 3);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        setupDisplay();
        setupButtons();
        setupStackDisplay();

        setResizable(false);
        pack();
        setVisible(true);
    }

    // Configuration du champ d'affichage pour la valeur courante
    private void setupDisplay() {
        jNumber.setEditable(false);
        jNumber.setBackground(Color.WHITE);
        jNumber.setHorizontalAlignment(JTextField.RIGHT);
        jNumber.setName("jNumber"); // Assign a unique name for testing
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 5;
        getContentPane().add(jNumber, constraints);
        constraints.gridwidth = 1;  // Réinitialisation de la largeur
    }

    // Ajout des boutons d'opérateurs
    private void setupButtons() {
        // Boutons de gestion de la mémoire et de la pile
        addOperatorButton("MR", 0, 1, Color.RED, new MemoryRecall());
        addOperatorButton("MS", 1, 1, Color.RED, new MemoryStore());
        addOperatorButton("<=", 2, 1, Color.RED, new Backspace());
        addOperatorButton("CE", 3, 1, Color.RED, new ClearError());
        addOperatorButton("C", 4, 1, Color.RED, new ClearAll());

        // Boutons numériques 1 à 9
        for (int i = 1; i < 10; i++) {
            addOperatorButton(String.valueOf(i), (i - 1) % 3, 4 - (i - 1) / 3, Color.BLUE, new Number(i) {
            });
        }
        addOperatorButton("0", 0, 5, Color.BLUE, new Number(0));

        // Boutons d'opérateurs
        addOperatorButton("+/-", 1, 5, Color.BLUE, new Negate());
        addOperatorButton(".", 2, 5, Color.BLUE, new DecimalPoint());

        // Opérateurs arithmétiques
        addOperatorButton("/", 3, 2, Color.RED, new Divide());
        addOperatorButton("*", 3, 3, Color.RED, new Multiply());
        addOperatorButton("-", 3, 4, Color.RED, new Subtract());
        addOperatorButton("+", 3, 5, Color.RED, new Add());

        // Opérateurs à un opérande
        addOperatorButton("1/x", 4, 2, Color.RED, new Inverse());
        addOperatorButton("x^2", 4, 3, Color.RED, new Square());
        addOperatorButton("Sqrt", 4, 4, Color.RED, new Sqrt());

        // Entrée dans la pile
        addOperatorButton("Ent", 4, 5, Color.RED, new Enter());
    }

    // Configuration de l'affichage de la pile
    private void setupStackDisplay() {
        JLabel jLabel = new JLabel("Stack");
        jLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
        jLabel.setHorizontalAlignment(JLabel.CENTER);
        constraints.gridx = 5;
        constraints.gridy = 0;
        getContentPane().add(jLabel, constraints);

        jStack.setFont(new Font("Dialog", Font.PLAIN, 12));
        jStack.setVisibleRowCount(8);
        jStack.setName("jStack"); // Assign a unique name for testing
        JScrollPane scrollPane = new JScrollPane(jStack);
        constraints.gridx = 5;
        constraints.gridy = 1;
        constraints.gridheight = 5;
        getContentPane().add(scrollPane, constraints);
        constraints.gridheight = 1;  // Réinitialisation de la hauteur
    }

    // Méthode pour ajouter un bouton avec son opérateur
    private void addOperatorButton(String name, int x, int y, Color color, final Operator operator) {
        JButton button = new JButton(name);
        button.setForeground(color);
        constraints.gridx = x;
        constraints.gridy = y;
        getContentPane().add(button, constraints);
        button.addActionListener((ActionEvent e) -> {
            operator.execute(state);  // Exécute l'opérateur avec l'état
            update();  // Met à jour l'affichage après chaque opération
        });
    }

    // Mise à jour de l'affichage après chaque opération
    private void update() {
        if (state.getError() != null) {
            jNumber.setText(state.getError()); // Affiche les erreurs
            state.clearError();
        } else {
            // Met à jour l'affichage avec la valeur courante
            String currentValueStr = state.getCurrentValueAsString();
            jNumber.setText(currentValueStr.isEmpty() ? "0" : currentValueStr);
        }

        // Met à jour l'affichage de la pile
        jStack.setListData(state.getStackArray());
    }


}
