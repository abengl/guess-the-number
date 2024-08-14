import java.util.Random;

/**
 * Represents a Computer src.Player
 */
public class ComputerPlayer extends Player {
    private final Random computerRandom;

    public ComputerPlayer(Random computerRandom) {
        super("Computer");
        this.computerRandom = computerRandom;
    }

    public static int randomNumber(Random random) {
        return random.nextInt(100) + 1;
    }

    @Override
    public int makeGuess() {
        int guess = randomNumber(computerRandom);
        System.out.println("Enter your guess: \n" + guess);
        guesses.add(guess);
        return guess;
    }
}

