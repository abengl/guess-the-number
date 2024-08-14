import java.util.Random;
import java.util.Scanner;

/**
 * Handles the main logic, decides which player assumes the next turn.
 **/
public class GuessTheNumberGame {
    private static final int MAX_NUMBER = 100;
    private final Player player1;
    private final Player player2;
    private final Random random;
    private final Scanner scanner;
    private int targetNumber;

    // Constructor
    public GuessTheNumberGame(Player player1, Player player2, Random random, Scanner scanner) {
        this.player1 = player1;
        this.player2 = player2;
        this.random = random;
        this.scanner = scanner;
        this.targetNumber = generateTargetNumber();
    }

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        Player player1 = createHumanPlayer(scanner);
        Player player2 = new ComputerPlayer(random);

        GuessTheNumberGame game = new GuessTheNumberGame(player1, player2, random, scanner);

        game.startGame();

        scanner.close();
    }

    private static HumanPlayer createHumanPlayer(Scanner scanner) {
        System.out.println("*** Welcome to the game Guess The Number! ***");
        System.out.println("What is your name? ");
        String username = scanner.nextLine();
        return new HumanPlayer(username, scanner);
    }

    public void startGame() {
        boolean playAgain;
        do {
            playRound();
            playAgain = askToPlayAgain();
            if (playAgain) {
                resetGame();
            }
        } while (playAgain);

        System.out.println("\n*** Thank you for playing! Goodbye! ***");
    }

    private void playRound() {
        while (true) {
            if (checkGuess(player1) || checkGuess(player2)) {
                break;
            }
        }
    }

    public boolean checkGuess(Player player) {
        System.out.println("-- Player: " + player.getName() + " ---");

        int guess = player.makeGuess();

        if (guess > targetNumber) {
            System.out.println("Too high!\n");
        } else if (guess < targetNumber) {
            System.out.println("Too low!\n");
        } else {
            System.out.println("Correct!\n");
            displayGameSummary(player);
            return true;
        }
        return false;
    }

    public void displayGameSummary(Player player) {
        System.out.println("Congratulations, " + player.getName() + "! You guessed the number " + targetNumber);
        System.out.println("Attempts: " + player.getGuess());
        System.out.println("Total attempts: " + player.getGuess().size());
    }

    private boolean askToPlayAgain() {
        System.out.println("\n** Do you want to play again? (yes/no) **");
        String answer = scanner.nextLine().trim().toLowerCase();
        return answer.equals("yes") || answer.equals("y");
    }

    private void resetGame() {
        this.targetNumber = generateTargetNumber();
        player1.resetGuesses();
        player2.resetGuesses();
        System.out.println("\n** Starting a new round... **\n");
    }

    private int generateTargetNumber() {
        return random.nextInt(MAX_NUMBER) + 1;
    }
}
