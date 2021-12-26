import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class GoblinTest {
    Goblin goblin;

    @BeforeEach
    void setUp() {
    }

    @Test
    void testToString() {
        String goblinString = "GOBLIN";
        byte[] bytes = goblinString.getBytes(StandardCharsets.UTF_8);

        String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
        assertEquals(goblinString, utf8EncodedString,"String does not match String in bytes");
    }

    @AfterEach
    void tearDown() {
    }
}