### **Rapport lab07 POO**

---

## **Choix de Conception**

### **1. Classe `State`**

#### **Responsabilités**

La classe `State` est le cœur du système. Elle encapsule l’état interne de la calculatrice, comprenant :

- La valeur courante.
- La pile pour les calculs intermédiaires.
- Les messages d’erreur éventuels.
- Les indicateurs de mode (nouvelle entrée, mode décimal, affichage d’un résultat).

#### **Structure**

- **Attributs principaux** :
    - `currentValue`: représente la valeur actuellement affichée.
    - `stack`: une pile pour stocker les valeurs intermédiaires.
    - `memory`: une zone mémoire pour stocker une valeur spécifique.
    - `isDecimalMode`, `isNewEntry`, `isResultDisplayed`: des indicateurs pour gérer l’état des entrées et des
      affichages.
- **Méthodes principales** :
    - Gestion de la pile (`pushCurrentValue`, `pop`).
    - Gestion des erreurs (`setError`, `clearError`).
    - Gestion de la mémoire (`storeInMemory`, `recallFromMemory`).
    - Conversion de la valeur courante en chaîne (`getCurrentValueAsString`).

#### **Décisions Architecturales**

- **Encapsulation** : Tous les attributs sont privés, avec des accesseurs et des mutateurs pour garantir un contrôle
  strict sur l’état.
- **Responsabilité unique** : La classe `State` se concentre uniquement sur la gestion de l’état de la calculatrice.
- **Composition** : Utilisation d’une classe générique `Stack` pour gérer les calculs intermédiaires, favorisant la
  réutilisabilité.

---

### **2. Classe `Operator`**

#### **Responsabilités**

La classe abstraite `Operator` définit une interface commune pour toutes les opérations. Elle permet à chaque opération
de modifier l’état de la calculatrice via un comportement polymorphique.

#### **Structure**

- **Méthode abstraite** :
    - `execute(State state)`: chaque sous-classe implémente cette méthode pour effectuer une opération spécifique.
- **Sous-classes concrètes** :
    - Opérations binaires : `Add`, `Subtract`, `Multiply`, `Divide`.
    - Opérations unaires : `Sqrt`, `Square`, `Negate`, `Inverse`.
    - Gestion de la pile : `Enter`.
    - Gestion de la mémoire : `MemoryRecall`, `MemoryStore`.
    - Contrôles : `Backspace`, `ClearError`, `ClearAll`.

#### **Décisions Architecturales**

- **Polymorphisme** : Les sous-classes de `Operator` implémentent la méthode `execute`, permettant d’ajouter de
  nouvelles opérations sans modifier le code existant.
- **Héritage** : Chaque opérateur hérite de `Operator` pour bénéficier d’une interface commune.
- **Extensibilité** : Ajouter une nouvelle opération ne nécessite que la création d’une nouvelle sous-classe de
  `Operator`.

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

---

### **2. Résultats obtenus**

| Test                             | Résultat attendu            | Résultat obtenu |
|----------------------------------|-----------------------------|-----------------|
| Addition (e.g., 5 + 3)           | Affiche `8`                 | Réussi          |
| Division par zéro                | Affiche `Erreur`            | Réussi          |
| Racine carrée (e.g., sqrt(-1))   | Affiche `Erreur`            | Réussi          |
| Gestion de la mémoire            | Rappel des valeurs stockées | Réussi          |
| Contrôle `Backspace`             | Supprime le dernier chiffre | Réussi          |
| Gestion des indicateurs d’entrée | Changements cohérents       | Réussi          |

Tous les tests ont été validés avec succès, confirmant le bon fonctionnement du système.

---

## **Conclusion**

La conception du système repose sur des principes solides d’architecture orientée objet, offrant une extensibilité et
une maintenance simplifiées. La séparation claire des responsabilités entre `State` et `Operator` garantit une gestion
robuste de l’état et des opérations. Les tests exhaustifs démontrent la fiabilité et la cohérence du système dans des
scénarios réels et exceptionnels.