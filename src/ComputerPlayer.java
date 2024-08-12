package src;

import java.util.Random;

/**
 * Represents a Computer src.Player
 */
public class ComputerPlayer extends Player {
    private static final Random computerRandom = new Random();

    public ComputerPlayer() {
        super("Computer");
    }

    private int randomNumber() {
        return computerRandom.nextInt(100) + 1;
    }

    @Override
    public int makeGuess() {
        int guess = randomNumber();
        System.out.println("Enter your guess: \n" + guess);
        guesses.add(guess);
        return guess;
    }
}

