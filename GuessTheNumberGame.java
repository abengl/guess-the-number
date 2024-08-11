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
        ComputerPlayer player2 = new ComputerPlayer();

        Random random = new Random();   // Random number generator
        int targetNumber = random.nextInt(100) + 1;     //Random number between 1-100

        boolean gameOver = false;
        while (true) {
            if (checkGuess(player1, targetNumber)) {
                gameSummary(player1);
                break;
            } else if (checkGuess(player2, targetNumber)) {
                gameSummary(player2);
                break;
            }
        }
    }

    public static void gameSummary(Player player) {
        System.out.println("Congratulations, " + player.getName() + "! You guessed the number.");
        System.out.println("Attempts: " + player.getGuess());
        System.out.println("Total attempts: " + player.getGuess().size());
    }

    // Executes a turn, obtains the guess, evaluates the game state.
    public static boolean checkGuess(Player player, int targetNumber) {
        System.out.println("-- Player: " + player.getName() + " ---");
        int guess = player.makeGuess();
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
