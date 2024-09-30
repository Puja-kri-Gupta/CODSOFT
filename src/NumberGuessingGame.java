import java.util.Random ;
import java.util.Scanner;

public class NumberGuessingGame {
    
    // method to play the game :
    public static void playGame(int maxRange, int maxAttempts) {
        Random random = new Random();
        //Generate the num b/w 1 and given maxRange by the user.
        int targetNo = random.nextInt(maxRange) +1;
        Scanner input = new Scanner(System.in);
        int attempts = 0;
        boolean isGuessedCorrectly = false;

        System.out.println("Guess a number between 1 and " + maxRange);

        // Loop allow the user to play, given maxAttempts
        while(attempts < maxAttempts) {
            System.out.print("Enter your Guess no : ");
            int userGuess = input.nextInt();
            attempts++;

            //check the userGuess no :
            if (userGuess == targetNo) {
                System.out.println("Congratulation ! You guessed the correct number in " + attempts + " attempts .");
                isGuessedCorrectly = true;
                break;
            } else if (userGuess < targetNo) {
                System.out.println("Your guess is too Low .");
            } else {
                System.out.println("Your guess is too High .");
            }
        }
        if(! isGuessedCorrectly) {
            System.out.println("Aw Aw . . . , You've used all your attempts. The correct number was : " + targetNo);
        }

    }

    // Game start :
    public static void startGame (){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Number Guessing Game !");
        System.out.print("Enter Maximum Range for the number : ");
        int maxRange = input.nextInt();
        System.out.print("Enter Maximum number of Attempts allowed : ");
        int maxAttempts = input.nextInt();

        boolean playAgain;
        int roundsWon = 0;

        do {
            playGame(maxRange, maxAttempts); // call the fun.

            // Ask the user if they want to play again :
            System.out.print("Do you want to play another round ? (yes/no) : ");
            playAgain = input.next().equalsIgnoreCase("yes");

            if(playAgain){
                roundsWon++;
            }
        } while(playAgain);

        System.out.println("Game Over ! You played " +roundsWon+ " rounds.");
    }


    public static void main(String[] args) {
        startGame();
    }
    
    
  }
