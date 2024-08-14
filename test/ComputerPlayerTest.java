import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;

class ComputerPlayerTest {
    private ComputerPlayer computerPlayerSpy;
    private Random randomMock;

    @BeforeEach
    void setUp() {
        randomMock = Mockito.mock(Random.class);
        computerPlayerSpy = spy(new ComputerPlayer(randomMock));
    }

    @Test
    @DisplayName("Test Player - getName()")
    void getNameComputerTest() {
        assertEquals("Computer", computerPlayerSpy.getName());
    }

    @Test
    @DisplayName("Test Player - getGuess()")
    void getGuessComputerTest() {
        Mockito.when(randomMock.nextInt(100)).thenReturn(80);
        ComputerPlayer.randomNumber(randomMock);

        computerPlayerSpy.makeGuess();

        ArrayList<Integer> expectedGuess = new ArrayList<>();
        expectedGuess.add(81);

        assertEquals(expectedGuess, computerPlayerSpy.getGuess());
    }

    @Test
    @DisplayName("Test Player - resetGuesses")
    void resetGuessesComputerTest() {
        computerPlayerSpy.resetGuesses();

        assertTrue(computerPlayerSpy.getGuess().isEmpty());
    }

    @Test
    @DisplayName("Test ComputerPlayer - randomNumber")
    void randomNumberComputerTest() {
        Mockito.when(randomMock.nextInt(100)).thenReturn(80);
        assertEquals(81, ComputerPlayer.randomNumber(randomMock));
    }

    @Test
    @DisplayName("Test ComputerPlayer - makeGuess")
    void makeGuessComputerTest() {
        Mockito.when(randomMock.nextInt(100)).thenReturn(80);

        int guess = computerPlayerSpy.makeGuess();

        assertEquals(81, guess);
    }

    @Test
    @DisplayName("Test ComputerPlayer - multiple guesses")
    void makeMultipleGuessesComputerTest() {
        Mockito.when(randomMock.nextInt(100)).thenReturn(0, 50, 99);

        assertEquals(1, computerPlayerSpy.makeGuess());
        assertEquals(51, computerPlayerSpy.makeGuess());
        assertEquals(100, computerPlayerSpy.makeGuess());

        ArrayList<Integer> expectedGuesses = new ArrayList<>();
        expectedGuesses.add(1);
        expectedGuesses.add(51);
        expectedGuesses.add(100);

        assertEquals(expectedGuesses, computerPlayerSpy.getGuess());
    }

}