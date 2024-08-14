import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.spy;

class HumanPlayerTest {
    // Stream to capture System.out output
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Scanner scannerMock;
    private HumanPlayer humanPlayerSpy;

    @BeforeEach
    void setUp() {
        scannerMock = Mockito.mock(Scanner.class);
        Mockito.when(scannerMock.nextLine()).thenReturn("player1");

        humanPlayerSpy = spy(new HumanPlayer(scannerMock.nextLine(), scannerMock));

        System.setOut(new PrintStream(outContent)); // Redirect System.out to our stream
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        scannerMock.close();
    }

    @Test
    @DisplayName("Test Player - getName()")
    void getNameTest() {
        assertEquals("player1", humanPlayerSpy.getName());
    }

    @Test
    @DisplayName("Test Player - getGuess()")
    void getGuessHumanTest() {
        Mockito.when(scannerMock.nextInt()).thenReturn(30);

        humanPlayerSpy.makeGuess();

        ArrayList<Integer> expectedGuess = new ArrayList<Integer>();
        expectedGuess.add(30);

        assertEquals(expectedGuess, humanPlayerSpy.getGuess());
    }

    @Test
    @DisplayName("Test HumanPlayer - makeGuess")
    void makeGuessHumanTestWithValidInput() {
        Mockito.when(scannerMock.nextInt()).thenReturn(20);
        assertEquals(20, humanPlayerSpy.makeGuess());
    }

    @Test
    @DisplayName("Test HumanPlayer - makeGuess")
    void makeGuessHumanTestWithNumberOutOfRange() {
        Mockito.when(scannerMock.nextInt())
                .thenReturn(200)    // First called outside range
                .thenReturn(20);  // Second call with valid input to end try loop

        int result = humanPlayerSpy.makeGuess(); // Stores the second attempt result

        // Validate that the corresponding message is printed
        String expectedOutput = "You are out of range. Please enter a number between 1 and 100.";
        assertTrue(outContent.toString().contains(expectedOutput));

        // Validate second guess accuracy
        assertEquals(20, result);
    }

    @Test
    @DisplayName("Test HumanPlayer - makeGuess")
    void makeGuessHumanTestWithInvalidInput() {
        Mockito.when(scannerMock.nextInt())
                .thenThrow(new InputMismatchException())  // First call throws exception
                .thenReturn(50);  // Second call with valid input to end try loop

        int result = humanPlayerSpy.makeGuess();    // Stores the second attempt result

        // Validate that the corresponding message is printed
        String expectedOutput = "Invalid input. Please enter a numeric value.";
        assertTrue(outContent.toString().contains(expectedOutput));

        // Validate second guess accuracy
        assertEquals(50, result);
    }

    @Test
    @DisplayName("Test Player - resetGuesses")
    void resetGuessesHumanTest() {
        humanPlayerSpy.resetGuesses();
        assertTrue(humanPlayerSpy.getGuess().isEmpty());
    }

    @Test
    @DisplayName("Test HumanPlayer - multiple guesses")
    void makeMultipleGuessesHumanTest() {
        Mockito.when(scannerMock.nextInt())
                .thenReturn(1)
                .thenReturn(50)
                .thenReturn(100);

        assertEquals(1, humanPlayerSpy.makeGuess());
        assertEquals(50, humanPlayerSpy.makeGuess());
        assertEquals(100, humanPlayerSpy.makeGuess());

        ArrayList<Integer> expectedGuesses = new ArrayList<>();
        expectedGuesses.add(1);
        expectedGuesses.add(50);
        expectedGuesses.add(100);

        assertEquals(expectedGuesses, humanPlayerSpy.getGuess());
    }

}