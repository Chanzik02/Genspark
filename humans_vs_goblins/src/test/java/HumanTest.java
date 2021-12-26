import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

class HumanTest {
    Human human;

    @BeforeEach
    void setUp() {

    }

    @Test
    void testToString() {
        String humanString = "HUMAN";
        byte[] bytes = humanString.getBytes(StandardCharsets.UTF_8);

        String utf8EncodedString = new String(bytes, StandardCharsets.UTF_8);
        assertEquals(humanString, utf8EncodedString, "Wrong string");
    }

    @AfterEach
    void tearDown() {
    }
}