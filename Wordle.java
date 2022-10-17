import java.util.Scanner;
import java.net.*;  
import java.io.*; 
public class Wordle{

    public static String check(String word)
        {
            // Determines if the word is the right length and is in the word list
            Scanner scanner = new Scanner(System.in);
            String wordList = Wordle.getUrlContents("https://www-cs-faculty.stanford.edu/~knuth/sgb-words.txt");
            while(word.length() != 5 || !wordList.contains(word.toLowerCase()))
            {
                System.out.println("That is not a valid word. Try again1!");
                word = scanner.nextLine().toUpperCase();
            }
            return word;
            
        }   

    public static String getUrlContents(String theUrl)  
    {   
    StringBuilder content = new StringBuilder();  
    // Use try and catch to avoid the exceptions  
    try  
    {  
      URL url = new URL(theUrl); // creating a url object  
      URLConnection urlConnection = url.openConnection(); // creating a urlconnection object  
  
      // wrapping the urlconnection in a bufferedreader  
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));  
      String line;  
      // reading from the urlconnection using the bufferedreader  
      while ((line = bufferedReader.readLine()) != null)  
      {  
        content.append(line);  
      }  
      bufferedReader.close();  
    }  
    
    catch(Exception e)  
    {  
      e.printStackTrace();  
    }  
    return content.toString();  
  }  
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String wordList = Wordle.getUrlContents("https://www-cs-faculty.stanford.edu/~knuth/sgb-words.txt");

        

        //Computer chooses the random word;
        int randomWordNumber = (int) (Math.random() * wordList.length());
        while((randomWordNumber) % 5 != 0)
        {
            randomWordNumber = (int) (Math.random() * wordList.length());
        }
        String computerGuess = wordList.substring((randomWordNumber), (randomWordNumber) + 5).toUpperCase();

        //Asking the user for a word input
        //Checking if the input is a valid word that is 5 characters long
        //Evaluating in each letter in the guess to see if it corresponds with the correct letter or is in the word at all
        //After 6 guesses, if the user still has not guessed the word, they lose
        for(int tries = 6; tries >= 0; tries--){
            System.out.println("\nEnter a five letter word: ");
            String userGuess = scanner.nextLine().toUpperCase();
            userGuess = Wordle.check(userGuess);
                for(int i = 0; i < userGuess.length(); i++)
                {
                    if(computerGuess.contains(userGuess.substring(i, i+1)))
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

 