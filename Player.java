import java.util.ArrayList;

/**
 * Represents a generic player. It is an abstract class.
 * Defines the attributes and methods that all player classes must share
 */
public abstract class Player {
    // The name of the player
    private final String name;
    // The player's guess history
    protected ArrayList<Integer> guesses;

    public Player(String name) {
        this.name = name;
        this.guesses = new ArrayList<Integer>();
    }

    // Returns the player's guess. It is an abstract method
    public abstract int makeGuess();

    // Returns the player's name
    public String getName() {
        return this.name;
    }

    // Returns the player's guess history
    public ArrayList<Integer> getGuess() {
        return this.guesses;
    }
}
