import java.util.Scanner;
import java.util.NoSuchElementException;

public class PrincipalGame {
    
    private enum GameStatus {WON, LOSE, CONTINUE};
    private GameStatus gameStatus;
    private int lifes;
    private String chosenWord;
    private boolean[] wasLetterChosen;
    private String hitVerificationWord;

    public PrincipalGame() {
        this.gameStatus = GameStatus.CONTINUE;
        this.lifes = 5;
        this.wasLetterChosen = new boolean[26];
        this.chosenWord = ChooseWord.chooseWord();
        this.hitVerificationWord = chosenWord;
    }
    
    public static void main(String[] args) {
        PrincipalGame game = new PrincipalGame();
        
        System.out.printf("%s%n%s%n%s%n",
            "Welcome to Hangman Game. How to play: A word will be choosen randomly and its letters will be hidden.",
            "You have to choose letters to complete it, if you pick a wrong one you will lose 1 life.",
            "You start the game with 5 lifes.");

        while(game.getGameStatus() == GameStatus.CONTINUE){
            game.showPainelGame();
            char c = game.requestInput();
            game.pickLetter(c);
            game.verifyStatus();
        }

        switch(game.getGameStatus()) {
            case GameStatus.WON:
            System.out.printf("%nCongratulations! You've won!");
            break;
            case GameStatus.LOSE:
            System.out.printf("%nYou've lost. The word was %s.", game.getChosenWord());
            break;
            default:
            System.err.println("Error. Shutting down.");
            System.exit(1);
        }
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
        Scanner input = new Scanner(System.in);
        String m = "";
        char character = ' ';

        System.out.printf("%s%n%s", 
            "Insert a letter:",
            "? ");

            while(character == ' ') {
                
                try {
                m = input.next();
                character = m.toLowerCase().charAt(0);

                if((Character.isDigit(character)) || (Character.isSpaceChar(character))) {
                    character = ' ';
                    System.err.println("Invalid input. Please, try again.");
                }
                else if(getwasLetterChosen()[(int) (character) - 97] == true) {
                    character = ' ';
                    System.err.println("You've already chosen this letter. Choose another one.\n");
                }
            }
            catch(NoSuchElementException elementException) {
                System.err.println("Invalid input. Please, try again.");
                character = ' ';
            }

            System.out.print("? ");
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
        else if(getHitVerificationWord() == "")
            setGameStatus(GameStatus.WON);
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