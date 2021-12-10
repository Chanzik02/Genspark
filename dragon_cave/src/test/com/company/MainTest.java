package com.company;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        main = new Main();
    }

    @DisplayName("Test for option 1")
    @org.junit.jupiter.api.Test
    void userInput1() {
        assertEquals("You did not get eaten.", main.userInput(1), "Test 1 Failed");
    }

    @DisplayName("Test for option 2")
    @org.junit.jupiter.api.Test
    void userInput2() {
        assertEquals("You approach the cave..." +
                        "\nIt is dark and spooky..." +
                        "\nA large dragon jumps out in front of you! He opens his jaws and..." +
                        "\nGobbles you down in one bite.",
                main.userInput(2), "Test 3 Failed");
    }

    @DisplayName("Test for other numbers")
    @org.junit.jupiter.api.Test
    void userInputNotAnOption() {
        assertEquals("Please choose the number 1 or 2.", main.userInput(3), "Test 3 Failed");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }
}