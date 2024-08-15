import java.util.Random;
import java.util.Scanner;

/**
 * Handles the main logic of the "Guess The Number" game, managing the players' turns,
 * checking guesses, and controlling the game flow.
 */
public class GuessTheNumberGame {
    private static final int MAX_NUMBER = 100;
    private final Player player1;
    private final Player player2;
    private final Random random;
    private final Scanner scanner;
    private int targetNumber;

    /**
     * Constructs a new {@code GuessTheNumberGame} with two players, a random number generator, and a scanner for input.
     *
     * @param player1 the first player, can be a human or a computer player
     * @param player2 the second player, can be a human or a computer player
     * @param random  the {@code Random} object used to generate the target number
     * @param scanner the {@code Scanner} object used to read input from the user
     */
    public GuessTheNumberGame(Player player1, Player player2, Random random, Scanner scanner) {
        this.player1 = player1;
        this.player2 = player2;
        this.random = random;
        this.scanner = scanner;
        this.targetNumber = generateTargetNumber();
    }

    /**
     * The main method to start the game. It sets up the players and the game instance, then begins the game.
     *
     * @param args the command line arguments (not used)
     */
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        Player player1 = createHumanPlayer(scanner);
        Player player2 = new ComputerPlayer(random);

        GuessTheNumberGame game = new GuessTheNumberGame(player1, player2, random, scanner);

        game.startGame();

        scanner.close();
    }

    /**
     * Prompts the user for their name and creates a new {@code HumanPlayer}.
     *
     * @param scanner the {@code Scanner} object used to read input from the user
     * @return a new {@code HumanPlayer} instance with the provided name
     */
    protected static HumanPlayer createHumanPlayer(Scanner scanner) {
        System.out.println("*** Welcome to the game Guess The Number! ***");
        System.out.println("What is your name? ");
        String username = scanner.nextLine();
        return new HumanPlayer(username, scanner);
    }

    /**
     * Starts the game loop, managing rounds until the player decides to stop playing.
     */
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

    /**
     * Manages a single round of the game, alternating between players until one guesses correctly.
     */
    private void playRound() {
        while (true) {
            if (checkGuess(player1) || checkGuess(player2)) {
                break;
            }
        }
    }

    /**
     * Checks the current player's guess against the target number and provides feedback.
     *
     * @param player the player making the guess
     * @return {@code true} if the guess is correct, {@code false} otherwise
     */
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

    /**
     * Displays a summary of the game, showing the winning player's name and their attempts.
     *
     * @param player the player who won the game
     */
    public void displayGameSummary(Player player) {
        System.out.println("Congratulations, " + player.getName() + "! You guessed the number " + targetNumber);
        System.out.println("Attempts: " + player.getGuess());
        System.out.println("Total attempts: " + player.getGuess().size());
    }

    /**
     * Asks the player if they want to play another round.
     *
     * @return {@code true} if the player wants to play again, {@code false} otherwise
     */
    private boolean askToPlayAgain() {
        System.out.println("\n** Do you want to play again? (yes/no) **");
        String answer = scanner.nextLine().trim().toLowerCase();
        return answer.equals("yes") || answer.equals("y");
    }

    /**
     * Resets the game by generating a new target number and clearing the players' guess histories.
     */
    protected void resetGame() {
        this.targetNumber = generateTargetNumber();
        player1.resetGuesses();
        player2.resetGuesses();
        System.out.println("\n** Starting a new round... **\n");
    }

    /**
     * Generates a new target number for the players to guess.
     *
     * @return the integer generated target number
     */
    protected int generateTargetNumber() {
        return random.nextInt(MAX_NUMBER) + 1;
    }
}
