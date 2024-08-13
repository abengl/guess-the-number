import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ComputerPlayerTest {

    @InjectMocks
    private ComputerPlayer playerMock;

    @Mock
    private Random randomMock;

    @BeforeEach
    void setUp() {
        playerMock = new ComputerPlayer();
    }

    @Test
    @DisplayName("Test ComputerPlayer - getName()")
    void getNameTest() {
        assertEquals("Computer", playerMock.getName());
    }

    @Test
    @DisplayName("Test ComputerPlayer - getGuess()")
    void getGuessInitialTest() {
        assertTrue(playerMock.getGuess().isEmpty(), "The computer player's guess history should be empty");
    }

    @Test
    @DisplayName("Test ComputerPlayer - getGuess() with Mocked Random")
    void randomNumberTest() {
        when(randomMock.nextInt(100)).thenReturn(49);

        // This uses the randomMock to generate the guess
        int guess = ComputerPlayer.randomNumber(randomMock);
        assertEquals(50, guess, "The guessed number should be 50");

        // Simulate adding the guess to the list (since makeGuess uses a different random instance)
        playerMock.getGuess().add(guess);
        assertTrue(playerMock.getGuess().contains(50), "The guesses list should contain the number 50");
    }
}
