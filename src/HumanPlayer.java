import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Represents a human player in the game. This class extends the {@link Player} class
 * and allows a human user to input their guesses.
 */
public class HumanPlayer extends Player {
    /**
     * The {@link Scanner} object used to read the player's input.
     */
    Scanner input;

    /**
     * Constructs a new HumanPlayer with the specified name and input source.
     *
     * @param name  The name of the player.
     * @param input The {@link Scanner} object used to capture the player's guesses.
     */
    public HumanPlayer(String name, Scanner input) {
        super(name);
        this.input = input;
    }

    /**
     * Prompts the human player to enter a guess. This method ensures that the guess is
     * a valid number between 1 and 100. If the player enters an invalid input, it prompts
     * them again until a valid guess is provided.
     *
     * @return The integer value of the player's valid guess.
     * @throws InputMismatchException if the input is not a valid integer.
     */
    @Override
    public int makeGuess() {
        System.out.println("Enter your guess: ");
        int guess = 0;
        while (true) {
            try {
                guess = input.nextInt();
                input.nextLine(); // Clean the scanner to prepare it for yes/no input later
                if (guess >= 1 && guess <= 100) break;
                else System.out.println("You are out of range. Please enter a number between 1 and 100.");
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value.");
                input.next();
            }
        }
        guesses.add(guess);
        return guess;
    }
}
