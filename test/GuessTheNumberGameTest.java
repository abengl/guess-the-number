import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GuessTheNumberGameTest {
    private Scanner scannerMock;
    private Player playerMock;
    private Player computerMock;
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
    @DisplayName("Test the target number is created")
    void generateTargetNumberTest() {
        int targetNumber = gameSpy.generateTargetNumber();

        verify(gameSpy, atLeastOnce()).generateTargetNumber();

        assertEquals(51, targetNumber);
    }

    @Test
    @DisplayName("Test the HumanPlayer is created")
    void createHumanPlayerTest() {
        when(scannerMock.nextLine()).thenReturn("Player1");

        HumanPlayer humanPlayer = GuessTheNumberGame.createHumanPlayer(scannerMock);

        assertEquals("Player1", humanPlayer.getName());

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
        Mockito.when(scannerMock.nextLine()).thenReturn("no");
        Mockito.when(playerMock.makeGuess()).thenReturn(51);

        gameSpy.startGame();

        verify(gameSpy).displayGameSummary(playerMock);
    }

    @Test
    @DisplayName("Test when computer guesses correctly and wins the game")
    void startGameEndsWithComputerWinner() {
        Mockito.when(scannerMock.nextLine()).thenReturn("no");
        Mockito.when(playerMock.makeGuess()).thenReturn(10);
        Mockito.when(computerMock.makeGuess()).thenReturn(51);

        gameSpy.startGame();

        verify(gameSpy).displayGameSummary(computerMock);

    }

    @Test
    @DisplayName("Test resetGame")
    void resetGameMainTest() {
        Mockito.when(scannerMock.nextLine()).thenReturn("yes").thenReturn("no");
        Mockito.when(playerMock.makeGuess()).thenReturn(51);

        gameSpy.startGame();

        verify(gameSpy, atLeastOnce()).resetGame(); // resetGuesses was called once
        verify(playerMock).resetGuesses(); // resetGuesses was called for player
        verify(computerMock).resetGuesses();    // resetGuesses was called for player
    }

    @Test
    @DisplayName("Test multiple rounds until human player wins")
    void multipleRoundsTest() {
        when(scannerMock.nextLine()).thenReturn("yes")  // To play 2 rounds
                .thenReturn("no");
        when(playerMock.makeGuess()).thenReturn(30)     // Person wins round 2
                .thenReturn(51);
        when(computerMock.makeGuess()).thenReturn(51);  // Computer wins round 1

        gameSpy.startGame();

        verify(gameSpy).displayGameSummary(computerMock);
        verify(playerMock, times(2)).makeGuess();
        verify(computerMock, times(1)).makeGuess();
    }

}
