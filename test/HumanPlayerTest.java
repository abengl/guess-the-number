import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.spy;

class HumanPlayerTest {
    private HumanPlayer humanPlayerSpy;
    private Scanner scannerMock;

    @BeforeEach
    void setUp() {
        scannerMock = Mockito.mock(Scanner.class);
        Mockito.when(scannerMock.nextLine()).thenReturn("player1");
        humanPlayerSpy = spy(new HumanPlayer(scannerMock.nextLine(), scannerMock));
    }

    @AfterEach
    void tearDown() {
        scannerMock.close();
    }

    @Test
    @DisplayName("Test HumanPlayer - getName()")
    void getName() {
        assertEquals("player1", humanPlayerSpy.getName());
    }

    @Test
    @DisplayName("Test HumanPlayer - getGuess()")
    void getGuess() {
        Mockito.when(scannerMock.nextInt()).thenReturn(30);
        humanPlayerSpy.makeGuess();
        ArrayList<Integer> expectedGuess = new ArrayList<Integer>();
        expectedGuess.add(30);

        assertEquals(expectedGuess, humanPlayerSpy.getGuess());

    }

    @Test
    @DisplayName("Test HumanPlayer - makeGuess")
    void makeGuess() {
        Mockito.when(scannerMock.nextInt()).thenReturn(20);
        assertEquals(20, humanPlayerSpy.makeGuess());
    }


}