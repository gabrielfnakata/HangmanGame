import java.util.Scanner;
import java.nio.file.Paths;
import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.util.NoSuchElementException;
import java.security.SecureRandom;

public class ChooseWord {

    private static SecureRandom randomNum = new SecureRandom();

    public static String chooseWord() {
        String allWords = new String();
        String[] words;
        
        try(Scanner input = new Scanner(Paths.get("words.txt"))) {

            while(input.hasNext()) {
                allWords = allWords.concat(input.next() + " ");
            }
        }
        catch(IOException ioException) {
            System.err.println("Error: " + ioException);
            System.exit(1);
        }
        catch(NoSuchElementException elementException) {
            System.err.println("Error: " + elementException);
        }
        catch(IllegalArgumentException illegalArgumentException) {
            System.err.println("Error: " + illegalArgumentException);
        }

        words = allWords.split("//s+");

        return words[randomNum.nextInt(words.length)];
    }
}