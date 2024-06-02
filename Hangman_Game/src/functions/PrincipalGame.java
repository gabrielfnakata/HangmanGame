package functions;

import java.util.Scanner;
import java.util.NoSuchElementException;

public class PrincipalGame {
    
    public enum GameStatus {WON, LOSE, CONTINUE};
    private GameStatus gameStatus;
    private int lifes;
    private String chosenWord;
    private boolean[] wasLetterChosen;
    private String hitVerificationWord;
    private static Scanner input = new Scanner(System.in);

    public PrincipalGame() {
        this.gameStatus = GameStatus.CONTINUE;
        this.lifes = 7;
        this.wasLetterChosen = new boolean[26];
        this.chosenWord = ChooseWord.chooseWord();
        this.hitVerificationWord = chosenWord;
    }

    public void showPainelGame() {
        System.out.print("\nChosen Letters: ");
        for(int c = 0; c < getwasLetterChosen().length; c++) {
            if(getwasLetterChosen()[c] == true)
                System.out.printf("%c ", (char) (c + 97));
        }

        System.out.printf("%n%s%d%n%s", 
            "Lifes: ", getLifes(),
            "Word: ");
        
        for(int c = 0; c < getChosenWord().length(); c++) {
            char character = getChosenWord().charAt(c);

            System.out.printf("%s ", (getwasLetterChosen()[(int) (character) - 97] == true) ? Character.toUpperCase(character) : "_");
        }

        System.out.println();
    }

    public char requestInput() {
        
        String m = "";
        char character = ' ';

        System.out.printf("%s", 
            "Insert a letter:");

            while(character == ' ') {
                
                try {
                
                System.out.print("\n? ");
                m = input.next();
                character = m.toLowerCase().charAt(0);

                if((Character.isDigit(character)) || (Character.isSpaceChar(character))) {
                    character = ' ';
                    System.err.println("Invalid input. Please, try again.");
                }
                else if(getwasLetterChosen()[(int) (character) - 97] == true) {
                    character = ' ';
                    System.err.println("You've already chosen this letter. Choose another one.");
                }
            }
            catch(NoSuchElementException elementException) {
                System.err.println("Invalid input. Please, try again.");
                character = ' ';
            }

        }

        return character;
    }

    public void pickLetter(char a) {
        getWasLetterChosen()[(int) (a) - 97] = true;
        
        if(getChosenWord().indexOf(a) == -1)
            setLifes(getLifes() - 1);
        else
            setHitVerificationWord(getHitVerificationWord().replaceAll(String.valueOf(a), "")); 
    }

    public void verifyStatus() {
        if(getLifes() == 0)
            setGameStatus(GameStatus.LOSE);
        else if(getHitVerificationWord().equals(""))
            setGameStatus(GameStatus.WON);
    }

    public void closeInput() {
        if(input == null)
            input.close();
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public int getLifes() {
        return lifes;
    }

    public void setLifes(int lifes) {
        this.lifes = lifes;
    }

    public String getChosenWord() {
        return chosenWord;
    }

    public void setChosenWord(String chosenWord) {
        this.chosenWord = chosenWord;
    }

    public boolean[] getwasLetterChosen() {
        return wasLetterChosen;
    }

    public void setwasLetterChosen(boolean[] wasLetterChosen) {
        this.wasLetterChosen = wasLetterChosen;
    }

    public boolean[] getWasLetterChosen() {
        return wasLetterChosen;
    }

    public void setWasLetterChosen(boolean[] wasLetterChosen) {
        this.wasLetterChosen = wasLetterChosen;
    }

    public String getHitVerificationWord() {
        return hitVerificationWord;
    }

    public void setHitVerificationWord(String hitVerificationWord) {
        this.hitVerificationWord = hitVerificationWord;
    }
}