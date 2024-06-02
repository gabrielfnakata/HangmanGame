package main;

import functions.*;
import functions.PrincipalGame.GameStatus;

public class HangmanMain {
    public static void main(String[] args) {
        PrincipalGame game = new PrincipalGame();
        
        System.out.printf("%s%n%s%n%s%n",
            "Welcome to Hangman Game. How to play: A word will be choosen randomly and its letters will be hidden.",
            "You have to choose letters to complete it, if you pick a wrong one you will lose 1 life.",
            "You start the game with 7 lifes.");
    
        while(game.getGameStatus() == GameStatus.CONTINUE) {
            game.showPainelGame();
            game.pickLetter(game.requestInput());
            game.verifyStatus();
        }
    
        switch(game.getGameStatus()) {
            case GameStatus.WON:
            System.out.printf("%n%s%nCongratulations! You've won!", game.getChosenWord().toUpperCase());
            break;
            case GameStatus.LOSE:
            System.out.printf("%nYou've lost. The word was %s.", game.getChosenWord());
            break;
            default:
            System.err.println("Error. Shutting down.");
            System.exit(1);
        }

        game.closeInput();
    }
}