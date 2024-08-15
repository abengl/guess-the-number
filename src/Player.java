import java.util.ArrayList;

/**
 * Represents a generic player in the game. This is an abstract class that
 * defines the common attributes and methods that all specific player types
 * (e.g. human, computer) classes must inherit and implement.
 */
public abstract class Player {
    private final String name;
    protected ArrayList<Integer> guesses;

    /**
     * Constructs a new Player with specific name.
     *
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name;
        this.guesses = new ArrayList<Integer>();
    }

    /**
     * Abstract method to make a guess in the game, it must be implemented
     * by subclasses.
     *
     * @return The integer value of the guess made.
     */
    public abstract int makeGuess();

    /**
     * Method to obtain the name of the player.
     *
     * @return The name of the player as a String.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Method to obtain the player's guess history.
     *
     * @return An ArrayList of integers representing the player's guess history.
     */
    public ArrayList<Integer> getGuess() {
        return this.guesses;
    }

    /**
     * Method to reset the player's guess history by clearing the list of guesses.
     */
    public void resetGuesses() {
        this.guesses.clear();
    }
}
