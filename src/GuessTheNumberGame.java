import java.util.Random;
import java.util.Scanner;

/**
 * Handles the main logic, decides which player assumes the next turn.
 **/
public class GuessTheNumberGame {
    private static final int MAX_NUMBER = 100;
    private final Player player1;
    private final Player player2;
    private final int targetNumber;
    private final Scanner scanner;

    // Constructor
    public GuessTheNumberGame(Player player1, Player player2, Random random, Scanner scanner) {
        this.player1 = player1;
        this.player2 = player2;
        this.targetNumber = random.nextInt(MAX_NUMBER) + 1;
        this.scanner = scanner;
    }

    public static void main(String[] args) {
        System.out.println("*** Welcome to the game Guess The Number! ***");

        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name? ");
        String username = scanner.nextLine();

        HumanPlayer player1 = new HumanPlayer(username, scanner);
        ComputerPlayer player2 = new ComputerPlayer();
        Random random = new Random();

        GuessTheNumberGame game = new GuessTheNumberGame(player1, player2, random, scanner);

        game.startGame();

        scanner.close();
    }

    public void startGame() {
        while (true) {
            if (checkGuess(player1)) {
                displayGameSummary(player1);
                break;
            } else if (checkGuess(player2)) {
                displayGameSummary(player2);
                break;
            }
        }
    }

    public boolean checkGuess(Player player) {
        System.out.println("-- Player: " + player.getName() + " ---");

        int guess = player.makeGuess();

        if (guess > targetNumber) {
            System.out.println("Too high!\n");
            return false;
        } else if (guess < targetNumber) {
            System.out.println("Too low!\n");
            return false;
        } else {
            System.out.println("Correct!\n");
            return true;
        }
    }

    public void displayGameSummary(Player player) {
        System.out.println("Congratulations, " + player.getName() + "! You guessed the number " + targetNumber);
        System.out.println("Attempts: " + player.getGuess());
        System.out.println("Total attempts: " + player.getGuess().size());
    }
}
