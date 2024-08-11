import java.util.Scanner;

/**
 * Represents the human player
 */
public class HumanPlayer extends Player {
    Scanner input = new Scanner(System.in);

    public HumanPlayer(String name) {
        super(name);
    }

    // Returns the player's guess
    @Override
    public int makeGuess() {
        System.out.println("Enter your guess: ");
        int guess = 0;
        boolean validInput = false;
        while (!validInput) {
            guess = input.nextInt();
            if (guess >= 1 && guess <= 100) {
//                System.out.println("Nice selection: " + guess);
                validInput = true;
            } else {
                System.out.println("You are out of range. Please enter a number between 1 and 100.");
            }
        }
        guesses.add(guess);
        return guess;
    }
}
