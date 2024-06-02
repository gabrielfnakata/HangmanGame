# **About this project**

This is a popular simple game made in Java, where you have to guess all the letters of a random chosen word without losing all your lifes.

## **Project Structure**

The main of the Hangman Game include:

### **1. Classes**

- **ChooseWord**: This class is responsible for opening the *words.txt* and randomly picking a word.
- **PrincipalGame**: Main class responsible for executing the game.

### **2. Files**

- **words.txt**: File containing 1300 words in english from A to Z, separated by spaces.

## **Libraries**

### **Class ChosenWord**
```java
import java.util.Scanner;
import java.nio.file.Paths;
import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.util.NoSuchElementException;
import java.security.SecureRandom;
```

### **Class PrincipalGame**
```java
import java.util.Scanner;
import java.util.NoSuchElementException;
```

## **How does it work?**

When the game starts, the letters of the chosen word will be replace by `_` and a input will be requested. 

For each wrong letter, 1 life is lost. When `lifes` reach `0` the game is over.

If you guess all the correct letters, the game is won.

## **Functions**

- **chooseWord()**: Function from the class *ChooseWord* that opens the file *words.txt* and randomly chooses a word by using `SecureRandom`.
- **showPainelGame()**: Function that displays the letters chosen by the player, the remaining lives, and the underlined and correct letters.
- **requestInput()**: Function that requests a letter and is also responsible for catching possible errors.
- **pickLetter()**: Function that marks a selected letter (important for the *requestInput* function) and removes one life if it's a wrong letter.
- **verifyGameStatus()**: Function that verifies if the player has either won or lost.

## **Constructor**

```java
public PrincipalGame() {
        this.gameStatus = GameStatus.CONTINUE; // Verifies the status of the game
        this.lifes = 7; // Initialize 7 lives
        this.wasLetterChosen = new boolean[26]; // Responsible for marking the picked letters
        this.chosenWord = ChooseWord.chooseWord(); // Calls the function that randomly chooses a word and stores it in a variable
        this.hitVerificationWord = chosenWord; // For each correct guess, the matching letters will be removed from it until it's empty
    }
```

Initialize the main game variables.
