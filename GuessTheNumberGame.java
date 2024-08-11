import java.util.Random;
import java.util.Scanner;

/**
 * Handles the main logic, decides which player assumes the next turn.
 **/
public class GuessTheNumberGame {
    // Begins the game and starts the random number
    public static void main(String[] args) {
        System.out.println("*** Welcome to the game Guess The Number! ***");

        Scanner sc = new Scanner(System.in);
        System.out.println("What is your name? ");
        String name = sc.nextLine();
        HumanPlayer player1 = new HumanPlayer(name);

//        System.out.println("Selecting a random number to guess...");
        Random random = new Random();   // Random number generator
        int targetNumber = random.nextInt(100) + 1;     //Random number between 1-100
//        System.out.println("Random number generated!");

        boolean gameOver = false;
        while (!gameOver) {
            gameOver = checkGuess(player1, sc, targetNumber);

        }
        System.out.println("Congratulations! " + player1.getName() + "! You guessed the number.");
        System.out.println("Attempts: " + player1.getGuess());
        System.out.println("Total attempts: " + player1.getGuess().size());
        sc.close();
    }

    // Executes a turn, obtains the guess, evaluates the game state.
    public static boolean checkGuess(Player player, Scanner scanner, int targetNumber) {
        System.out.println("-- Player: " + player.getName() + " ---");
        int guess = player.makeGuess(scanner);
        if (guess > targetNumber) {
            System.out.println("Too high!");
            return false;
        } else if (guess < targetNumber) {
            System.out.println("To low!");
            return false;
        } else {
            return true;
        }
    }
}
