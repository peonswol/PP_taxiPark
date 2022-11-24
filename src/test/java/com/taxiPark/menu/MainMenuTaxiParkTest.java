package com.taxiPark.menu;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainMenuTaxiParkTest extends TestCase {

    MainMenuTaxiPark mainMenuTaxiPark = new MainMenuTaxiPark();

    private final PrintStream standardOut = System.out; // new PrintStream(byteArrayOutputStream);
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @Test
    public void testConstructor(){
        assertEquals(5, mainMenuTaxiPark.sizeOfCommands());
    }

    @Test
    public void testSizeOfCommands() {
        assertEquals(5, mainMenuTaxiPark.sizeOfCommands());
    }

    @Test
    public void testCallIntoMenu() {
        mainMenuTaxiPark.callIntoMenu();
        assertNotEquals("""
                Welcome to TAXI PARK :

                \t[1] - add new car
                \t[2] - show list
                \t[3] - select car by id
                \t[4] - cost of autopark
                \t[0] - exit

                Enter command :""", byteArrayOutputStream.toString().trim());
    }

    @Test
    public void testExecute() {
    }

    @Test
    public void testOpenTaxiParkProgramme() {
    }
}