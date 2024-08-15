import java.util.Random;

/**
 * Represents a computer-controlled player in the game.
 * The {@code ComputerPlayer} class extends the {@link Player} class,
 * providing an implementation where the computer generates random guesses.
 */
public class ComputerPlayer extends Player {
    /**
     * The {@link Random} object used to generate a random number.
     */
    private final Random computerRandom;

    /**
     * Constructs a {@code ComputerPlayer} with the specified random number generator.
     *
     * @param computerRandom the {@link Random} instance used to generate the computer's guesses.
     */
    public ComputerPlayer(Random computerRandom) {
        super("Computer");
        this.computerRandom = computerRandom;
    }

    /**
     * Generates a random number between 1 and 100.
     *
     * @param random the {@link Random} instance used to generate the number.
     * @return a randomly generated number between 1 and 100 (inclusive).
     */
    public static int randomNumber(Random random) {
        return random.nextInt(100) + 1;
    }

    /**
     * Makes a guess by generating a random number between 1 and 100.
     * The generated number is added to the list of guesses and returned.
     *
     * @return the integer randomly generated guess.
     */
    @Override
    public int makeGuess() {
        int guess = randomNumber(computerRandom);
        System.out.println("Enter your guess: \n" + guess);
        guesses.add(guess);
        return guess;
    }
}

