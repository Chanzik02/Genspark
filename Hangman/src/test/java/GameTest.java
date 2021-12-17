import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        game = new Game();
    }


    @DisplayName("Chooses a random word in inventory.")
    @org.junit.jupiter.api.Test
    void selectionOfWords1() {
        assertNotEquals("help", game.selectionOfWords(), "Failed word is in inventory.");
    }

    @DisplayName("Chooses a random word in inventory.")
    @org.junit.jupiter.api.Test
    void selectionOfWords2() {
        assertEquals("null", game.selectionOfWords(), "Failed word is in inventory.");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }
}