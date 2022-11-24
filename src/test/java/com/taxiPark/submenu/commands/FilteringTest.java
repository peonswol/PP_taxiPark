package com.taxiPark.submenu.commands;

import junit.framework.TestCase;
import org.junit.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class FilteringTest extends TestCase {

    Filtering filtering = new Filtering();

    private final PrintStream standardOut = System.out; // new PrintStream(byteArrayOutputStream);
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();


    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    void sizeOfCommands() {
    }

    /*@Test
    void callIntoMenuAndShowMenu() {
        filtering.callIntoMenu();

        assertEquals("\nSelect a filtering item :\n" +
                "\n" +
                "\t[0] - mark\n" +
                "\t[1] - year manufacture\n" +
                "\t[2] - cost\n" +
                "\t[3] - color\n" +
                "\t[4] - max speed\n" +
                "\t[5] - engine capacity\n" +
                "\t[6] - fuel type\n" +
                "\t[7] - fuel consumption for 100 km\n" +
                "\n" +
                "\t[8] - show cars\n" +
                "\n" +
                "Enter command :\t", systemOutRule.getLogWithNormalizedLineSeparator());
    }
*/
    @Test
    public void testConstructor(){
        assertEquals(9, filtering.sizeOfCommands());
    }
}