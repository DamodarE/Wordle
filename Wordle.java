import java.util.Scanner;
import com.javatpoint.wordFile;
public class Wordle{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wordList = wordFile.getUrlContents("https://www-cs-faculty.stanford.edu/~knuth/sgb-words.txt");

        //Computer chooses the random word;
        int randomWordNumber = (int) (Math.random() * wordList.length());
        while((randomWordNumber) % 5 != 0)
        {
            randomWordNumber = (int) (Math.random() * wordList.length());
        }
        String computerGuess = wordList.substring((randomWordNumber), (randomWordNumber) + 5).toUpperCase();
        System.out.println(computerGuess);

        //Asking the user for a word input
        //Checking if the input is a valid word that is 5 characters long
        //Evaluating in each letter in the guess to see if it corresponds with the correct letter or is in the word at all
        //After 6 guesses, if the user still has not guessed the word, they lose
        for(int tries = 5; tries >= 0; tries--){
            System.out.println("Enter a five letter word: ");
            String userGuess = scanner.nextLine().toUpperCase();
            userGuess = checkWord.check(userGuess);
                for(int i = 0; i < userGuess.length(); i++)
                {
                    if(computerGuess.contains(userGuess.substring(i, i+1))&& userGuess.indexOf(userGuess.substring(i, i+1)) == i)
                    {
                        if(userGuess.substring(i, i + 1).equals(computerGuess.substring(i, i + 1)))
                        {
                            System.out.print("\u001B[32m" + userGuess.substring(i, i + 1) + "\u001B[0m");
                        }
                        else
                        {
                            System.out.print("\u001B[33m" + userGuess.substring(i, i + 1) + "\u001B[0m");
                        }
                    }
                    else
                    {
                        System.out.print("\u001B[30m" + userGuess.substring(i, i + 1) + "\u001B[0m");
                    }
                }
                System.out.println("");

                if(userGuess.equals(computerGuess))
                {
                    System.out.println("YOU WIN!!!");
                    break;
                }
                else if(tries != 0)
                {
                    System.out.println("You have " + (tries) + " guesses left!");
                }
                else
                {
                    System.out.println("YOU LOSE! \n The word was " + computerGuess);
                }
        }
        scanner.close();
    }
}

 