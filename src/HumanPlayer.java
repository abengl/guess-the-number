import java.util.Scanner;

/**
 * Represents the human player
 */
public class HumanPlayer extends Player {
    Scanner input;

    public HumanPlayer(String name, Scanner input) {
        super(name);
        this.input = input;
    }

    // Returns the player's guess
    @Override
    public int makeGuess() {
        System.out.println("Enter your guess: ");
        int guess;
        while (true) {
            guess = input.nextInt();
            if (guess >= 1 && guess <= 100) break;
            else System.out.println("You are out of range. Please enter a number between 1 and 100.");
        }
        guesses.add(guess);
        return guess;
    }
}
