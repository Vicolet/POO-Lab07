# Rapport Labo 7 - Calculatrice
Victor Nicolet, Léon Surbeck

## **1. Classe `Stack`**

### **Responsabilités**

La classe `Stack` est une classe générique utilisée pour gérer les calculs intermédiaires. Elle permet de stocker et de
récupérer des valeurs dans un ordre LIFO (Last In, First Out).

### **Structure**

- **Méthodes** :
    - `push(E item)`: ajoute un élément en haut de la pile.
    - `pop()`: retire et renvoie l'élément en haut de la pile.
    - `isEmpty()`: vérifie si la pile est vide.
    - `toArray()`: convertit la pile en un tableau.
    - `iterator()`: renvoie un itérateur pour parcourir les éléments de la pile.

### **Décisions Architecturales**

- **Réutilisabilité** : La classe `Stack` est générique, ce qui permet de l'utiliser avec différents types d'éléments.
- **Simplicité** : Les opérations de base de la pile sont implémentées de manière simple et efficace.

---

## **2. Classe `Operator`**

### **Responsabilités**

La classe abstraite `Operator` définit une interface commune pour toutes les opérations. Elle permet à chaque opération
de modifier l’état de la calculatrice via un comportement polymorphique.

### **Structure**

- **Méthode abstraite** :
    - `execute(State state)`: chaque sous-classe implémente cette méthode pour effectuer une opération spécifique.
- **Sous-classes concrètes** :
    - Opérations binaires : `Add`, `Subtract`, `Multiply`, `Divide`.
    - Opérations unaires : `Sqrt`, `Square`, `Negate`, `Inverse`.
    - Gestion de la pile : `Enter`.
    - Gestion de la mémoire : `MemoryRecall`, `MemoryStore`.
    - Contrôles : `Backspace`, `ClearError`, `ClearAll`.

### **Hiérarchie des classes**

- `Operator` hérite de `DefaultOperator`.
- `DefaultOperator` hérite de `UnaryOperator`.
- `UnaryOperator` hérite de `BinaryOperator`.

### **Décisions Architecturales**

- **Polymorphisme** : Les sous-classes de `Operator` implémentent la méthode `execute`, permettant d’ajouter de
  nouvelles opérations sans modifier le code existant.
- **Héritage** : Chaque opérateur hérite de `Operator` pour bénéficier d’une interface commune.
- **Extensibilité** : Ajouter une nouvelle opération ne nécessite que la création d’une nouvelle sous-classe de
  `Operator`.

### **Décisions Architecturales**

- **Polymorphisme** : Les sous-classes de `Operator` implémentent la méthode `execute`, permettant d’ajouter de
  nouvelles opérations sans modifier le code existant.
- **Héritage** : Chaque opérateur hérite de `Operator` pour bénéficier d’une interface commune.
- **Extensibilité** : Ajouter une nouvelle opération ne nécessite que la création d’une nouvelle sous-classe de
  `Operator`.

---

## **3. Classe `State`**

### **Responsabilités**

La classe `State` gère l'état interne de la calculatrice, y compris les opérations sur la pile, la gestion de la
mémoire, la gestion des erreurs et les utilitaires de formatage.

### **Structure**

- **Attributs** :
    - `stack`: une instance de `Stack` pour gérer les valeurs intermédiaires.
    - `currentValue`: la valeur actuelle affichée par la calculatrice.
    - `memory`: la valeur stockée en mémoire.
    - `error`: le message d'erreur actuel.
    - `isNewEntry`, `isResultDisplayed`, `isDecimalMode`: indicateurs de l'état de la calculatrice.

- **Méthodes** :
    - `pushCurrentValue()`, `pop()`, `getStack()`: opérations sur la pile.
    - `setCurrentValue(double value)`, `getCurrentValue()`: gestion de la valeur actuelle.
    - `storeInMemory()`, `recallFromMemory()`: gestion de la mémoire.
    - `setError(String error)`, `getError()`, `clearError()`: gestion des erreurs.
    - `clearAll()`: réinitialise tous les attributs de l'état.
    - `getStackArray()`: convertit la pile en un tableau de chaînes.
    - `getCurrentValueAsString()`: formate la valeur actuelle en chaîne.

### **Décisions Architecturales**

- **Encapsulation** : La classe `State` encapsule tous les aspects de l'état de la calculatrice, facilitant la gestion
  et la modification de cet état.
- **Modularité** : Les différentes responsabilités (pile, mémoire, erreurs) sont bien séparées au sein de la classe
  `State`.

---

## **Tests Effectués**

### **1. Cas d’utilisation testés**

#### **Tests sur la classe `State`**

1. **Gestion de la pile** :
    - Pousser et extraire des valeurs.
    - Résultat attendu : les valeurs sont stockées et récupérées dans l’ordre LIFO (Last In, First Out).
2. **Gestion des erreurs** :
    - Déclenchement d’erreurs comme la division par zéro.
    - Résultat attendu : un message d’erreur est défini et supprimé correctement.
3. **Modes d’entrée et d’affichage** :
    - Gestion des indicateurs `isNewEntry` et `isResultDisplayed`.
    - Résultat attendu : l’état change de manière cohérente en fonction des actions de l’utilisateur.

#### **Tests sur les classes `Operator`**

1. **Opérations binaires** :
    - Addition, soustraction, multiplication, division.
    - Résultats attendus : les résultats des opérations correspondent aux calculs arithmétiques standard.
2. **Opérations unaires** :
    - Racine carrée, carré, inversion, négation.
    - Résultats attendus : les résultats respectent les règles mathématiques (e.g., racine carrée d’un nombre négatif
      génère une erreur).
3. **Gestion de la mémoire** :
    - Stockage et rappel de valeurs avec `MemoryStore` et `MemoryRecall`.
    - Résultats attendus : les valeurs sont correctement stockées et récupérées.
4. **Contrôles** :
    - `Backspace` supprime le dernier chiffre de la valeur courante.
    - `ClearError` et `ClearAll` réinitialisent l’état de la calculatrice.
    - Résultats attendus : les contrôles fonctionnent sans modifier la pile ou la mémoire, sauf indication contraire.

#### **Tests d’intégration**

- Interaction entre les classes `State` et `Operator`.
- Résultats attendus : les opérations modifient l’état et l’affichage de manière cohérente.

### **2. Résultats obtenus**

| **StackTest**             | **Result** |  | **StateTest**                | **Result** |
|---------------------------|------------|--|------------------------------|------------|
| `testToArray()`           | ✅ Passed   |  | `testCurrentValue()`         | ✅ Passed   |
| `testPop()`               | ✅ Passed   |  | `testStackToArray()`         | ✅ Passed   |
| `testSize()`              | ✅ Passed   |  | `testStackOperations()`      | ✅ Passed   |
| `testPopFromEmptyStack()` | ✅ Passed   |  | `testFlags()`                | ✅ Passed   |
| `testPushAndToString()`   | ✅ Passed   |  | `testMemoryOperations()`     | ✅ Passed   |
| `testIsEmpty()`           | ✅ Passed   |  | `testErrorHandling()`        | ✅ Passed   |
| `testIterator()`          | ✅ Passed   |  | `testCurrentValueAsString()` | ✅ Passed   |
|                           |            |  | `testClearAll()`             | ✅ Passed   |

| **JCalculatorTest**          | **Result** | | **CalculatorTest**              | **Result** |
|------------------------------|------------|-|---------------------------------|------------|
| `testClearError()`           | ✅ Passed   | | `testMemoryStoreAndRecall()`    | ✅ Passed   |
| `testAdd()`                  | ✅ Passed   | | `testMultiplication()`          | ✅ Passed   |
| `testSubtract()`             | ✅ Passed   | | `testAddition()`                | ✅ Passed   |
| `testEnter()`                | ✅ Passed   | | `testEnterPushesValueToStack()` | ✅ Passed   |
| `testSqrt()`                 | ✅ Passed   | | `testDivisionByZero()`          | ✅ Passed   |
| `testMemoryRecallAndStore()` | ✅ Passed   | | `testDivision()`                | ✅ Passed   |
| `testDecimalPoint()`         | ✅ Passed   | | `testSquareRoot()`              | ✅ Passed   |
| `testDivide()`               | ✅ Passed   | | `testClearAll()`                | ✅ Passed   |
| `testMultiply()`             | ✅ Passed   | | `testInvalidInput()`            | ✅ Passed   |
| `testClearAll()`             | ✅ Passed   | | `testNegate()`                  | ✅ Passed   |
| `testInverse()`              | ✅ Passed   | | `testSquare()`                  | ✅ Passed   |
| `testNegate()`               | ✅ Passed   | | `testSubtraction()`             | ✅ Passed   |
| `testNumber()`               | ✅ Passed   | | `testBackspace()`               | ✅ Passed   |
| `testSquare()`               | ✅ Passed   |
| `testBackspace()`            | ✅ Passed   |

Tous ces tests unitaires sont disponibles dans le dossier `starter/test/`.
Tous les tests ont été exécutés avec succès, démontrant la robustesse et la fiabilité du système.