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
    // Stream para capturar la salida de System.out
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private Scanner scannerMock;
    private HumanPlayer humanPlayerSpy;

    @BeforeEach
    void setUp() {
        scannerMock = Mockito.mock(Scanner.class);
        Mockito.when(scannerMock.nextLine()).thenReturn("player1");
        humanPlayerSpy = spy(new HumanPlayer(scannerMock.nextLine(), scannerMock));

        // Redirigimos el System.out a nuestro stream
        System.setOut(new PrintStream(outContent));
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
    void getGuessTest() {
        Mockito.when(scannerMock.nextInt()).thenReturn(30);
        humanPlayerSpy.makeGuess();
        ArrayList<Integer> expectedGuess = new ArrayList<Integer>();
        expectedGuess.add(30);

        assertEquals(expectedGuess, humanPlayerSpy.getGuess());
    }

    @Test
    @DisplayName("Test HumanPlayer - makeGuess")
    void makeGuessTestWithValidInput() {
        Mockito.when(scannerMock.nextInt()).thenReturn(20);
        assertEquals(20, humanPlayerSpy.makeGuess());
    }

    @Test
    @DisplayName("Test HumanPlayer - makeGuess")
    void makeGuessTestWithNumberOutOfRange() {
        Mockito.when(scannerMock.nextInt())
                .thenReturn(200)    // Primera llamada retorna un número fuera de rango
                .thenReturn(20);  // Segunda llamada devuelve un número válido para salir del loop
        // del try

        int result = humanPlayerSpy.makeGuess(); // Guarda el resultado del segundo intento

        // Verificar que se imprimió el mensaje esperado
        String expectedOutput = "You are out of range. Please enter a number between 1 and 100.";
        assertTrue(outContent.toString().contains(expectedOutput));

        // Verificar que la apuesta es válida en el segundo intento
        assertEquals(20, result);
    }

    @Test
    @DisplayName("Test HumanPlayer - makeGuess")
    void makeGuessTestWithInvalidInput() {
        Mockito.when(scannerMock.nextInt())
                .thenThrow(new InputMismatchException())  // Primera llamada lanza excepción
                .thenReturn(50);  // Segunda llamada devuelve un número válido

        int result = humanPlayerSpy.makeGuess();    // Guarda el resultado del segundo intento

        // Verificar que se imprimió el mensaje esperado
        String expectedOutput = "Invalid input. Please enter a numeric value.";
        assertTrue(outContent.toString().contains(expectedOutput));

        // Verificar que la apuesta es válida en el segundo intento
        assertEquals(50, result);
    }

    @Test
    @DisplayName("Test Player - resetGuesses")
    void resetGuessesTest() {
        humanPlayerSpy.resetGuesses();
        assertTrue(humanPlayerSpy.getGuess().isEmpty());
    }

}