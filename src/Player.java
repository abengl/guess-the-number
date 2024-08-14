import java.util.ArrayList;

/**
 * Represents a generic player. It is an abstract class.
 * Defines the attributes and methods that all player classes must share
 */
public abstract class Player {
    private final String name;
    protected ArrayList<Integer> guesses;

    public Player(String name) {
        this.name = name;
        this.guesses = new ArrayList<Integer>();
    }

    // Returns the player's guess
    public abstract int makeGuess();

    // Returns the player's name
    public String getName() {
        return this.name;
    }

    // Returns the player's guess history
    public ArrayList<Integer> getGuess() {
        return this.guesses;
    }

    public void resetGuesses() {
        this.guesses.clear();
    }
}
