import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HumanPlayerTest {
    private HumanPlayer humanPlayer;
    private Scanner scanner;

    @BeforeEach
    void setUp() {
        humanPlayer = new HumanPlayer("player1", scanner);
    }

    @Test
    @DisplayName("Test HumanPlayer - getName()")
    void getName() {
        assertEquals("player1", humanPlayer.getName());
    }

    @Test
    void getGuess() {
    }

    @Test
    void makeGuess() {
    }

}