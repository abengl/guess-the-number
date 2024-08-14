import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

class ComputerPlayerTest {
    private ComputerPlayer computerPlayerSpy;
    private Random randomMock;

    @BeforeEach
    void setUp() {
        randomMock = Mockito.mock(Random.class);
        computerPlayerSpy = spy(new ComputerPlayer(randomMock));
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("Test computerPlayer - getName()")
    void getName() {
        assertEquals("Computer", computerPlayerSpy.getName());
    }

    @Test
    @DisplayName("Test computerPlayer - randomNumber")
    void randomNumber() {
        Mockito.when(randomMock.nextInt(100)).thenReturn(80);
        assertEquals(81, ComputerPlayer.randomNumber(randomMock));
    }

    @Test
    @DisplayName("Test ComputerPlayer - getGuess()")
    void getGuess() {
        Mockito.when(randomMock.nextInt(100)).thenReturn(80);
        ComputerPlayer.randomNumber(randomMock);

        computerPlayerSpy.makeGuess();

        ArrayList<Integer> expectedGuess = new ArrayList<>();
        expectedGuess.add(81);

        assertEquals(expectedGuess, computerPlayerSpy.getGuess());

    }

    @Test
    @DisplayName("Test ComputerPlayer - makeGuess")
    void makeGuess() {
        Mockito.when(randomMock.nextInt(100)).thenReturn(80);
        ComputerPlayer.randomNumber(randomMock);
        int guess = computerPlayerSpy.makeGuess();
        assertEquals(81, guess);
    }

}