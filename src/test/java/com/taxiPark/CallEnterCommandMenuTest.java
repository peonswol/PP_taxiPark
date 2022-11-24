package com.taxiPark;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class CallEnterCommandMenuTest {

    CallEnterCommandMenu callEnterCommandMenu = new CallEnterCommandMenu();

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown(){
    }

    @Test
    public void testEnterCommandCheckException() {
        String enteredCommand = "4\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));
        int actualCommand = callEnterCommandMenu.enterCommandCheckException(new Scanner(System.in), 5);
        assertEquals(4, actualCommand);
        }

    @Test
    public void testThrowsExceptionEnterCommandCheckException() {
        String enteredCommand = "е\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));
        assertThrows(NoSuchElementException.class, () ->  callEnterCommandMenu.enterCommandCheckException(new Scanner(System.in), 3));

    }

    @Test
    public void testEnterCommand() {
        String enteredCommand = "4\n";
        System.setIn(new ByteArrayInputStream(enteredCommand.getBytes()));
        assertThrows(NumberFormatException.class, () ->  callEnterCommandMenu.enterCommand(new Scanner(System.in), 3));
    }

}