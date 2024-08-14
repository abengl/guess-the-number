import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

class GuessTheNumberGameTest {
    private Scanner scannerMock;
    private HumanPlayer playerMock;
    private ComputerPlayer computerMock;
    private GuessTheNumberGame gameSpy;

    @BeforeEach
    void setUp() {
        Random randomMock = Mockito.mock(Random.class);
        Mockito.when(randomMock.nextInt(100)).thenReturn(50);

        scannerMock = Mockito.mock(Scanner.class);
        playerMock = Mockito.mock(HumanPlayer.class);
        computerMock = Mockito.mock(ComputerPlayer.class);
        gameSpy = spy(new GuessTheNumberGame(playerMock, computerMock, randomMock, scannerMock));
    }

    @AfterEach
    void tearDown() {
        scannerMock.close();
    }

    @Test
    @DisplayName("Test when user guess correctly")
    void checkGuessCorrect() {
        Mockito.when(playerMock.makeGuess()).thenReturn(51);
        assertTrue(gameSpy.checkGuess(playerMock));
    }

    @Test
    @DisplayName("Test when user guess to low")
    void checkGuessTooLow() {
        Mockito.when(playerMock.makeGuess()).thenReturn(10);
        assertFalse(gameSpy.checkGuess(playerMock));
    }

    @Test
    @DisplayName("Test when user guess too high")
    void checkGuessTooHigh() {
        Mockito.when(playerMock.makeGuess()).thenReturn(90);
        assertFalse(gameSpy.checkGuess(playerMock));
    }

    @Test
    @DisplayName("Test when user guesses correctly and wins the game")
    void startGameEndsWithHumanWinner() {
        Mockito.when(playerMock.makeGuess()).thenReturn(51);
        Mockito.when(computerMock.makeGuess()).thenReturn(1);

        gameSpy.startGame();

        verify(gameSpy).displayGameSummary(playerMock);
    }

    @Test
    @DisplayName("Test when computer guesses correctly and wins the game")
    void startGameEndsWithComputerWinner() {
        Mockito.when(playerMock.makeGuess()).thenReturn(10);
        Mockito.when(computerMock.makeGuess()).thenReturn(51);

        gameSpy.startGame();

        verify(gameSpy).displayGameSummary(computerMock);
    }

}
