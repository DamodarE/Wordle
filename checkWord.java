import java.util.Scanner;
import com.javatpoint.wordFile;
public class checkWord {

    public static String check(String word)
    {
        Scanner scanner = new Scanner(System.in);

        // Determines if the word is the right length and is in the word list
        while(word.length() != 5 || !wordFile.getUrlContents("https://www-cs-faculty.stanford.edu/~knuth/sgb-words.txt").contains(word.toLowerCase()))
        {
            System.out.println("That is not a valid word. Try again1!");
            word = scanner.nextLine().toUpperCase();
        }
        return word;
        
    }   
}
