public class PrincipalGame {
    
    private enum GameStatus {WON, LOSE, CONTINUE};
    private static GameStatus gameStatus;
    private static int lifes;
    private static String chosenWord;
    private static boolean[] isLetterChosen;
    
    public static void main(String[] args) {
        System.out.printf("%s%n%s%n%s%n",
            "Welcome to Hangman Game. How to play: A word will be choosen randomly and its letters will be hidden.",
            "You have to choose letters to complete it, if you pick a wrong one you will lose 1 life.",
            "You start the game with 5 lifes.");

        gameStatus = GameStatus.CONTINUE;
        lifes = 5;
        isLetterChosen = new boolean[26];
        chosenWord = ChooseWord.chooseWord();
        while(gameStatus == GameStatus.CONTINUE){
            showPainelGame();
        }
    }

    public static void showPainelGame() {
        System.out.print("\nChosen Letters: ");
        for(int c = 0; c < isLetterChosen.length; c++) {
            if(isLetterChosen[c] == true)
                System.out.printf("%c ", (char) (c - 97));
        }

        System.out.printf("%n%20s%d%n%s", 
            "Lifes: ", lifes,
            "Word: ");
        
        for(int c = 0; c < isLetterChosen.length; c++) {
            char character = (char) (c - 97);
            if(chosenWord.indexOf(character) != -1) {
                System.out.printf("%s ", (isLetterChosen[c] == true) ? Character.toUpperCase(character) : "_");
            }
        }
    }

    public static void verifyStatus() {
        if(lifes == 0)
            gameStatus = GameStatus.LOSE;
        else if()
            gameStatus = GameStatus.WON;
    }
}
