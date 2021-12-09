import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        main = new Main();
    }

    @DisplayName("Check if name only contains letters")
    @org.junit.jupiter.api.Test
    void checkNameForLettersOnly() {
        assertTrue(main.checkName("John"));
    }

    @DisplayName("Check if name contains other characters")
    @org.junit.jupiter.api.Test
    void checkNameForOtherChar() {
        assertFalse(main.checkName("j0h!>"));
    }



    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }


}