package test;

import org.junit.jupiter.api.Test;
import src.HumanPlayer;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GuessTheNumberGameTest {
    @Test
    void main() {
        Scanner testScanner = new Scanner(System.in);
        HumanPlayer player1 = new HumanPlayer("player1", testScanner);
        assertEquals("player1", player1.getName());
    }
//    @Test
//    void checkGuess() {
//    }
}